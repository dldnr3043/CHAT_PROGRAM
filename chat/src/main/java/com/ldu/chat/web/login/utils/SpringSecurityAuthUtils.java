package com.ldu.chat.web.login.utils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.ldu.chat.jpa.user.entity.UserEntity;
import com.ldu.chat.jpa.user.repository.UserRepository;

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
public class SpringSecurityAuthUtils {
	
	/**
     * 
     * @param username
     * @return
     */
    public Collection<? extends GrantedAuthority> createAuthorities(UserEntity user)
    {
    	final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
    	
    	if("ADMIN".equals(user.getAuthCd())) {
    		authorities.add(new SimpleGrantedAuthority(SpringSecurityRoleEnum.ROLES.ADMIN));
    	}
    	else if("USER".equals(user.getAuthCd())) {
    		authorities.add(new SimpleGrantedAuthority(SpringSecurityRoleEnum.ROLES.USER));
    	}
    	
        return authorities;         
    }
}
