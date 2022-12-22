package com.ldu.chat.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * LogoutSuccessHandler : 로그아웃에 성공했을 시 수행되는 핸들러이다.
 * SimpleUrlLogoutSuccessHandler를 상속한 CustomLogoutSuccessHandler를 등록해주었다.
 * 역시 성공시 로그인 페이지로 리다이렉트 하는 역할을 수행한다.
 *
 */
@Slf4j
public class ChatLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	@Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        log.debug("ChatLogoutSuccessHandler.onLogoutSuccess ::::");
        
        super.onLogoutSuccess(request, response, authentication);
    }
}
