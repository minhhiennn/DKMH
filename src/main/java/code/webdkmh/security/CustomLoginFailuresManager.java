package code.webdkmh.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.github.mkopylec.recaptcha.RecaptchaProperties;
import com.github.mkopylec.recaptcha.security.login.LoginFailuresManager;
import com.github.mkopylec.recaptcha.validation.RecaptchaValidator;
import com.github.mkopylec.recaptcha.validation.ValidationResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginFailuresManager extends LoginFailuresManager {

    int errorcount = 0;

    @Autowired
    private RecaptchaValidator recaptchaValidator;

    public CustomLoginFailuresManager(RecaptchaProperties recaptcha) {

        super(recaptcha);
    }

    @Override
    public void addLoginFailure(HttpServletRequest arg0) {
        errorcount++;
    }

    @Override
    public void clearLoginFailures(HttpServletRequest arg0) {
        errorcount++;
    }

    @Override
    public int getLoginFailuresCount(HttpServletRequest arg0) {
        ValidationResult result = recaptchaValidator.validate(arg0);
        if (result.isSuccess()) {
        } else {
        }

        return 1;
    }

}
