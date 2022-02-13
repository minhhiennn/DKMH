package code.webdkmh.security;

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
public class MySimpleUrlAuthenticationSuccessHandler1 extends LoginFailuresClearingHandler {

    @Autowired
    private RecaptchaValidator recaptchaValidator;

    public MySimpleUrlAuthenticationSuccessHandler1(LoginFailuresManager failuresManager) {
        super(failuresManager);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // System.out.println(failuresManager.getLoginFailuresCount(request));
        // handle(request, response, authentication);
        // clearAuthenticationAttributes(request);
        ValidationResult result = recaptchaValidator.validate(request);
        if (result.isSuccess()) {
        } else {
        }
    }

}
