package com.ldu.chat.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 실패시 행동을 재정의할 클래스(추상 클래스가 아닌 인터페이스를 구현해도 된다.) Or Interface - AuthenticationFailureHandler
 * 
 * AuthenticationFailureHandler : Form Login 실패시 수행되는 핸들러이다. SimpleUrlAuthenticationFailureHandler를 상속한 CustomAuthenticationFailureHandler를 등록해주었다. 이 또한 단순히 실패시 로그인 페이지로 리다이렉트 하는 역할을 수행한다..
 *
 */
@Slf4j
public class ChatAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	/**
     * BadCredentialException 비밀번호가 일치하지 않을 때 던지는 예외 InternalAuthenticationServiceException 존재하지 않는 아이디일 때 던지는 예외 AuthenticationCredentialNotFoundException 인증 요구가 거부됐을 때 던지는 예외 LockedException 인증 거부 - 잠긴 계정
     * DisabledException 인증 거부 - 계정 비활성화 AccountExpiredException 인증 거부 - 계정 유효기간 만료 CredentialExpiredException 인증 거부 - 비밀번호 유효기간 만료.
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
    {
        log.info("TeletalkAuthenticationFailureHandler.onAuthenticationFailure ::: {}", request.getRequestURI());
        log.debug("TeletalkAuthenticationFailureHandler.onAuthenticationFailure ::: {}", exception);
        
        log.debug("login fail :::::::::::::::::::::::::");

        super.onAuthenticationFailure(request, response, exception);
    }
}
