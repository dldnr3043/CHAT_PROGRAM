package com.ldu.chat.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import com.ldu.chat.jpa.user.repository.ChatJpaUserRepository;
import com.ldu.chat.web.login.dto.ChatWebLoginUserDto;

import lombok.extern.slf4j.Slf4j;

/**
 * LogoutSuccessHandler : 로그아웃에 성공했을 시 수행되는 핸들러이다.
 * SimpleUrlLogoutSuccessHandler를 상속한 CustomLogoutSuccessHandler를 등록해주었다.
 * 역시 성공시 로그인 페이지로 리다이렉트 하는 역할을 수행한다.
 *
 */
@Slf4j
public class ChatLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	
	@Autowired
	private ChatJpaUserRepository chatJpaUserRepository;
	
	@Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        log.debug("ChatLogoutSuccessHandler.onLogoutSuccess ::::");
        
        Object principal = authentication.getPrincipal();
        ChatWebLoginUserDto chatWebLoginUserDto = (ChatWebLoginUserDto) principal;
        
        chatJpaUserRepository.updateLoginYn(chatWebLoginUserDto.getCustChannelId(), chatWebLoginUserDto.getUserEmail(), "N");
        
        //세션 저장
        HttpSession session = request.getSession();
        session.setAttribute("USER_ID", chatWebLoginUserDto.getUsrname());
        
        super.onLogoutSuccess(request, response, authentication);
    }
}
