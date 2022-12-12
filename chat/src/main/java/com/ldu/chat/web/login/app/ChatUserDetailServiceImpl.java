package com.ldu.chat.web.login.app;

import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ldu.chat.jpa.user.entity.UserEntity;
import com.ldu.chat.jpa.user.repository.UserRepository;
import com.ldu.chat.web.login.domain.SpringSecurityUserDomain;
import com.ldu.chat.web.login.utils.SpringSecurityAuthUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class ChatUserDetailServiceImpl implements UserDetailsService {

	private final UserRepository 		  userRepository;
	private final SpringSecurityAuthUtils springSecurityAuthUtils;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findById(userId);
		
		if(ObjectUtils.isEmpty(user))
        {
            throw new BadCredentialsException("Invalid username or password :::");
        }
		
		user.get().setAuthorities(springSecurityAuthUtils.createAuthorities(user.get()));
		
		boolean isEnabled = "Y".equals(user.get().getUseYn()) ? true : false;
		boolean isAccountNonExpired = true;
		boolean isCredentialsNonExpired = true;
		boolean isAccountNonLocked = true;
		
		SpringSecurityUserDomain springSecurityUserDomain = new SpringSecurityUserDomain(user.get().getUserId()
																					  , user.get().getUserName()
																					  , user.get().getUserPassword()
																					  , user.get().getAuthCd()
																					  , user.get().getUseYn()
																					  , isEnabled
																					  , isAccountNonExpired
																					  , isCredentialsNonExpired
																					  , isAccountNonLocked
																					  , user.get().getAuthorities());
		
		return springSecurityUserDomain;
	}

}
