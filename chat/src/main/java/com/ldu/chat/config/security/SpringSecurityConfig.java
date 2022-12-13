package com.ldu.chat.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsUtils;

import com.ldu.chat.config.property.ChatProjectConfig;
import com.ldu.chat.web.login.utils.ChatWebLoginRoleEnum;

/**
 * Spring Security Config
 * 
 * @author ldu
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ChatProjectConfig chatProjectConfig;
	
	/**
	 * HttpSecurity Filter
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
		    .antMatchers("/signup").permitAll()
		    .antMatchers("/**").hasRole(ChatWebLoginRoleEnum.CODES.ADMIN)
		    .anyRequest()
		    .authenticated()
		    .and()
		    .formLogin()
		    .loginPage("/chat/web/login")
		    .usernameParameter("username")
		    .passwordParameter("password")
		    .loginProcessingUrl("/login-process")
		    .successHandler(authenticationSuccessHandler())
            .failureHandler(authenticationFailureHandler())
            .permitAll();
	}
	
	/**
	 * WebSecurity Filter
	 */
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/**/css/**")
           .antMatchers("/**/js/**")
           .antMatchers("/**/**/css/**")
           .antMatchers("/**/**/js/**");
    }
	
	/**
     * SuccessHandler bean register
     * 
     * Form Login(AuthenticationFilter)에서 인증이 성공했을 때 수행될 핸들러이다.
     * SimpleUrlAuthenticationSuccessHandler를 상속한 SavedRequestAwareAuthenticationSuccessHandler를
     * 다시 상속한 TeletalkAuthenticationSuccessHandler를 등록해주었다.
     * @return successHandler
     */
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() throws Exception
    {
        ChatAuthenticationSuccessHandler successHandler = new ChatAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl(chatProjectConfig.getServiceUrl() + chatProjectConfig.getMainPath());
        successHandler.setAlwaysUseDefaultTargetUrl(true);
        return successHandler;
    }

    /**
     * FailureHandler bean register
     * 
     * Form Login 실패시 수행되는 핸들러이다.
     * SimpleUrlAuthenticationFailureHandler를 상속한 TeletalkAuthenticationFailureHandler를 등록해주었다.
     * 이 또한 단순히 실패시 로그인 페이지로 리다이렉트 하는 역할을 수행한다.
     * @return failureHandler
     */
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() throws Exception
    {
        ChatAuthenticationFailureHandler failureHandler = new ChatAuthenticationFailureHandler();
        failureHandler.setDefaultFailureUrl("/chat/web/login");
        failureHandler.setUseForward(true);
        return failureHandler;
    }
}
