package code.webdkmh.utli.security;

import com.github.mkopylec.recaptcha.security.login.FormLoginConfigurerEnhancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private FormLoginConfigurerEnhancer enhancer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        enhancer.addRecaptchaSupport(http.authorizeRequests()
                .antMatchers("/student/*").hasRole("st")
                .and().formLogin()).loginPage("/login")
                .successHandler(captchaAuthenticationSuccessHandler)
                // .failureUrl("/login?error=true")
                // .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable().cors();
    }

    // @Override
    // protected void configure(final HttpSecurity http) throws Exception {
    // http.authorizeRequests()
    // .antMatchers("/student/*").hasRole("st")
    // .and()
    // .formLogin()
    // .loginPage("/login")
    // // .loginProcessingUrl("/perform_login")
    // .successHandler(myAuthenticationSuccessHandler())
    // .failureUrl("/login?error=true")
    // .permitAll()
    // .and()
    // .logout()
    // .logoutUrl("/logout")
    // .invalidateHttpSession(true)
    // .deleteCookies("JSESSIONID")
    // .and()
    // .csrf().disable().cors();
    // ;
    // // .and()
    // // .exceptionHandling().accessDeniedPage("/accessDenied");
    // }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Autowired
    CaptchaAuthenticationSuccessHandler captchaAuthenticationSuccessHandler;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
