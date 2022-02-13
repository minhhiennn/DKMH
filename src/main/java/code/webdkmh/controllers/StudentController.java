package code.webdkmh.controllers;

import code.webdkmh.dao.entities.PasswordResetToken;
import code.webdkmh.dao.entities.Users;
import code.webdkmh.dao.service.PasswordResetTokenService;
import code.webdkmh.dao.service.SecurityService;
import code.webdkmh.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.text.RandomStringGenerator;

@Controller
public class StudentController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordResetTokenService passwordResetTokenService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = {"/student/", "/student/home"})
    public String shopPage(Model model) {
        try {
            model.addAttribute("listUsers", "1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/forgotPassword")
    public String forgotPassword() {
        return "student/forgotPassword";
    }

    @RequestMapping(value = "/login")
    public String loginError(HttpServletRequest request, Model model,
                             @RequestParam(value = "error", required = false) String error) {
        if (error != null && error.equals("true")) {
            HttpSession session = request.getSession(false);
            String errorMessage = null;
            if (session != null) {
                AuthenticationException ex = (AuthenticationException) session
                        .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
                if (ex != null) {
                    errorMessage = ex.getMessage();
                }
            }
            model.addAttribute("errorMessage", errorMessage);
        }
        return "student/login";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public String resetPassword(HttpServletRequest request,
                                @RequestParam("idUser") String idUser) throws MessagingException, UnsupportedEncodingException {
        Users user = userService.findById(idUser);
        String userEmail = user.getEmail();
        String siteUrl = request.getRequestURL().toString().replace(request.getServletPath(), "");
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setIdUser(idUser);
        String token = UUID.randomUUID().toString();
        passwordResetToken.setToken(token);
        passwordResetToken.setExpiryDate(new Date());
        System.out.println(passwordResetToken);
        passwordResetTokenService.save(passwordResetToken);
        this.sendEmailForgetPassword(userEmail, token, siteUrl);
        return "mail are already send";
    }

    @RequestMapping(value = "/changePassword")
    @ResponseBody
    public String changePassword(Model model, @RequestParam("token") String token) {
        String result = securityService.valiDatePasswordResetToken(token);
        if (result != null) {
            return result;
        } else {
            Optional<Users> user = userService.getUserByPasswordResetToken(token);
            if (user.isPresent()) {
                RandomStringGenerator generator = new RandomStringGenerator.Builder()
                        .withinRange('0', 'z')
                        .filteredBy(Character::isLetterOrDigit)
                        .build();
                // tạo ngẫu nhiên 1 mật khẩu có độ dài 8
                String randomLetters = generator.generate(8);
                userService.changeUserPassword(user.get(), randomLetters);
                return "password were change :" + randomLetters;
            } else {
                return "user not found";
            }
        }
    }

    private void sendEmailForgetPassword(String toUserEmail, String token, String siteURL) throws MessagingException, UnsupportedEncodingException {
        toUserEmail = "18130076@st.hcmuaf.edu.vn";
        String toAddress = toUserEmail;
        String fromAddress = "minhhien2000k@gmail.com";
        String senderName = "HienPro";
        String subject = "Forget Password";
        String content = "Dear [[name]],<br>"
                + "To complete the password reset process, please click here: <br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">[[URL]]</a></h3>"
                + "Thank you,<br>"
                + "HienPro.";

        MimeMessage message = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", toUserEmail);
        String verifyURL = siteURL + "/changePassword?token=" + token;

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        this.mailSender.send(message);
    }
}
