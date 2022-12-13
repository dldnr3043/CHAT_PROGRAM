package com.ldu.chat.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 인증이 성공했을 때 수행될 핸들러(추상 클래스가 아닌 인터페이스를 구현해도 된다.) Or Interface - AuthenticationSuccessHandler
 *
 */
@Slf4j
public class ChatAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException
    {
        log.info("ChatAuthenticationSuccessHandler.onAuthenticationSuccess ::: {}", request.getRequestURI());
        log.debug("ChatAuthenticationSuccessHandler.onAuthenticationSuccess ::: {}", authentication);

        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        
        //세션 저장
        HttpSession session = request.getSession();
        session.setAttribute("USER_ID", userDetails.getUsername());
        
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
