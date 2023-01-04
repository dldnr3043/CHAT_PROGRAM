package com.ldu.chat.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

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
			// url에 대한 authentication 처리
			.authorizeRequests()
		    .antMatchers("/chat/web/signup").permitAll()					// 회원가입 페이지
		    .antMatchers("/api/chat/signup/**").permitAll()					// 회원가입 관련 api
		    .antMatchers("/api/chat/common/selectAllUsedCustChannel").permitAll()	// 전체 고객사리스트 조회 api
		    .antMatchers("/chat/web/admin/**").hasRole(ChatWebLoginRoleEnum.CODES.ADMIN)
		    .antMatchers("/**").hasRole(ChatWebLoginRoleEnum.CODES.USER)
		    .anyRequest()
		    .authenticated()
		    // login 설정
		    .and()
		    .formLogin()
		    .loginPage(chatProjectConfig.getLoginPath())
		    .usernameParameter("username")
		    .passwordParameter("password")
		    .loginProcessingUrl("/login-process")
		    .successHandler(authenticationSuccessHandler())
            .failureHandler(authenticationFailureHandler())
            .permitAll()
            // logout 설정
            .and()
            .logout()
            .logoutUrl(chatProjectConfig.getLogoutPath())
            .deleteCookies("LDUSESSIONID")
            .logoutSuccessHandler(logoutSuccessHandler())
            .invalidateHttpSession(true)
            .permitAll()
            // X-Frame-Options Click Jacking default로 막기 때문에 iframe 에러 그래서 같은 도메인은 허용
            .and()
            .headers().frameOptions().sameOrigin()
            // csrf 설정
            .and()
            .csrf().disable(); 
		
		
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
        successHandler.setDefaultTargetUrl(chatProjectConfig.getMainPath());
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
        failureHandler.setDefaultFailureUrl(chatProjectConfig.getLoginPath());
        failureHandler.setUseForward(true);
        return failureHandler;
    }
    
    /**
     * LogoutSuccessHandler bean register
     * 
     * 로그아웃에 성공했을 시 수행되는 핸들러이다.
     * SimpleUrlLogoutSuccessHandler를 상속한 TeletalkLogoutSuccessHandler를 등록해주었다.
     * 역시 성공시 로그인 페이지로 리다이렉트 하는 역할을 수행한다.
     * @return logoutSuccessHandler
     */
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() throws Exception
    {
    	ChatLogoutSuccessHandler logoutSuccessHandler = new ChatLogoutSuccessHandler();
        logoutSuccessHandler.setDefaultTargetUrl(chatProjectConfig.getLoginPath());
        logoutSuccessHandler.setAlwaysUseDefaultTargetUrl(true);
        return logoutSuccessHandler;
    }
    
    /**
     * BCryptPasswordEncoder를 통해 비밀번호를 암호화하여 저장
     * 
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
