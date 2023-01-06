package com.ldu.chat.web.login.utils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.ldu.chat.jpa.user.entity.ChatJpaUserEntity;
import com.ldu.chat.jpa.user.repository.ChatJpaUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author ldu
 *
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class ChatWebLoginAuthUtils {
	
	/**
	 * ADMIN : 관리자
	 * USER  : 일반사용자
	 * NONE  : 초기권한없음
	 * 
	 * @param user
	 * @return
	 */
    public Collection<? extends GrantedAuthority> createAuthorities(ChatJpaUserEntity user)
    {
    	final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
    	
    	if("ADMIN".equals(user.getAuthCd())) {
    		authorities.add(new SimpleGrantedAuthority(ChatWebLoginRoleEnum.ROLES.ADMIN));
    		authorities.add(new SimpleGrantedAuthority(ChatWebLoginRoleEnum.ROLES.USER));
    		authorities.add(new SimpleGrantedAuthority(ChatWebLoginRoleEnum.ROLES.NONE));
    	}
    	else if("USER".equals(user.getAuthCd())) {
    		authorities.add(new SimpleGrantedAuthority(ChatWebLoginRoleEnum.ROLES.USER));
    		authorities.add(new SimpleGrantedAuthority(ChatWebLoginRoleEnum.ROLES.NONE));
    	}
    	else if("NONE".equals(user.getAuthCd())) {
    		authorities.add(new SimpleGrantedAuthority(ChatWebLoginRoleEnum.ROLES.NONE));
    	}
    	
        return authorities;         
    }
}
