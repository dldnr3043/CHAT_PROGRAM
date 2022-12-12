package com.ldu.chat.web.login.domain;

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
public class SpringSecurityUserDomain extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String usrname;
	private String authCd;
	private String useYn;
	
	
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
	public SpringSecurityUserDomain(String username
								  , String usrname
								  , String password
								  , String authCd
								  , String useYn
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
		this.userId = username;
		this.usrname = usrname;
		this.authCd = authCd;
		this.useYn = useYn;
	}

}
