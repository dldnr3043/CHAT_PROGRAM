package com.ldu.chat.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security Config
 * 
 * @author ldu
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * HttpSecurity Filter
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/").permitAll()
		    .antMatchers("/signup").permitAll()
		    .anyRequest()
		    .authenticated()
		    .and()
		    .formLogin()
		    .loginPage("/login")
		    .usernameParameter("username")
		    .passwordParameter("password")
		    .loginProcessingUrl("/login-process")
//		    .successHandler(authenticationSuccessHandler())
//            .failureHandler(authenticationFailureHandler())
            .permitAll();
	}
	
	/**
	 * WebSecurity Filter
	 */
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("**/css/**")
           .antMatchers("**/js/**")
           .antMatchers("**/**/css/**")
           .antMatchers("**/**/js/**");
    }
}
