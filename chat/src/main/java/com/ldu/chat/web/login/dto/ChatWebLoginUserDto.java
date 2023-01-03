package com.ldu.chat.web.login.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

/**
 * Spring Security login 객체
 * 
 * @author ldu
 *
 */
@Getter
@Setter
public class ChatWebLoginUserDto extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userEmail;
	private String usrname;
	private String authCd;
	private String useYn;
	private String custChannelId;
	
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public ChatWebLoginUserDto(String username
								  , String usrname
								  , String password
								  , String authCd
								  , String useYn
								  , String custChannelId
								  , boolean enabled
								  , boolean accountNonExpired
								  , boolean credentialsNonExpired
								  , boolean accountNonLocked
								  , Collection<? extends GrantedAuthority> authorities) 
	{
		super(username
			, password
			, enabled
			, accountNonExpired
			, credentialsNonExpired
			, accountNonLocked
			, authorities);
		
		// Custom value
		this.userEmail = username;
		this.usrname = usrname;
		this.authCd = authCd;
		this.useYn = useYn;
		this.custChannelId = custChannelId;
	}

}
