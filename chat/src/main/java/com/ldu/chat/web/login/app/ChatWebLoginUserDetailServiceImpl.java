package com.ldu.chat.web.login.app;

import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ldu.chat.jpa.user.entity.ChatJpaUserEntity;
import com.ldu.chat.jpa.user.repository.ChatJpaUserRepository;
import com.ldu.chat.web.login.dto.ChatWebLoginUserDto;
import com.ldu.chat.web.login.utils.ChatWebLoginAuthUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class ChatWebLoginUserDetailServiceImpl implements UserDetailsService {

	private final ChatJpaUserRepository 		  userRepository;
	private final ChatWebLoginAuthUtils springSecurityAuthUtils;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		ChatJpaUserEntity user = userRepository.selectUserEntity("1", userId);
		
		if(ObjectUtils.isEmpty(user))
        {
            throw new BadCredentialsException("Invalid username or password :::");
        }
		
		user.grantAuthorities(springSecurityAuthUtils.createAuthorities(user));
		
		boolean isEnabled = "Y".equals(user.getUseYn()) ? true : false;
		boolean isAccountNonExpired = true;
		boolean isCredentialsNonExpired = true;
		boolean isAccountNonLocked = true;
		
		ChatWebLoginUserDto chatWebLoginUserDto = new ChatWebLoginUserDto(user.getUserEmail()
																					  , user.getUserName()
																					  , user.getUserPassword()
																					  , user.getAuthCd()
																					  , user.getUseYn()
																					  , isEnabled
																					  , isAccountNonExpired
																					  , isCredentialsNonExpired
																					  , isAccountNonLocked
																					  , user.getAuthorities());
		
		return chatWebLoginUserDto;
	}

}
