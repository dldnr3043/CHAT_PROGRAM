package com.ldu.chat.web.login.utils;

import org.springframework.security.core.GrantedAuthority;

public enum ChatWebLoginRoleEnum implements GrantedAuthority {
	ADMIN  (ROLES.ADMIN  , "관리자"),
	USER   (ROLES.USER   , "사용자");

	/**
	 * 코드 정의 상수
	 *
	 */
	public static class CODES {
		public static final String ADMIN   = "ADMIN";
		public static final String USER    = "USER";
	}
	
	/**
	 * 역할 정의 상수
	 *
	 */
	public static class ROLES {
		public static final String ADMIN   = "ROLE_ADMIN";
		public static final String USER    = "ROLE_USER";
	}
	
	private String authority;
	private String description;
	
	private ChatWebLoginRoleEnum(String authority, String description) {
		this.authority = authority;
		this.description = description;
	}
	
	@Override
	public String getAuthority() {
		return this.authority;
	}
	
	public String getDescription() {
		return this.description;
	}

}
