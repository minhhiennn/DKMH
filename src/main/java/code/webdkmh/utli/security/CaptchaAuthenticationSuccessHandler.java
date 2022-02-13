package code.webdkmh.utli.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.mkopylec.recaptcha.validation.RecaptchaValidator;
import com.github.mkopylec.recaptcha.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import com.github.mkopylec.recaptcha.security.login.LoginFailuresClearingHandler;
import com.github.mkopylec.recaptcha.security.login.LoginFailuresManager;

import org.springframework.stereotype.Component;

@Component
public class CaptchaAuthenticationSuccessHandler extends LoginFailuresClearingHandler {

    @Autowired
    private RecaptchaValidator recaptchaValidator;

    public CaptchaAuthenticationSuccessHandler(LoginFailuresManager failuresManager) {
        super(failuresManager);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        ValidationResult result = recaptchaValidator.validate(request);
        if (result.isSuccess()) {
            System.out.println("ok");
        } else {
            System.out.println("no ok");
        }
    }

}
