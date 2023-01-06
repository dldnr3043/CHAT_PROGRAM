package com.ldu.chat.web.login.utils;

import org.springframework.security.core.GrantedAuthority;

public enum ChatWebLoginRoleEnum implements GrantedAuthority {
	SYSTEM (ROLES.SYSTEM  , "시스템관리자"),
	ADMIN  (ROLES.ADMIN  , "관리자"),
	USER   (ROLES.USER   , "사용자"),
	NONE   (ROLES.NONE   , "초기");

	/**
	 * 코드 정의 상수
	 *
	 */
	public static class CODES {
		public static final String SYSTEM  = "SYSTEM";
		public static final String ADMIN   = "ADMIN";
		public static final String USER    = "USER";
		public static final String NONE    = "NONE";
	}
	
	/**
	 * 역할 정의 상수
	 *
	 */
	public static class ROLES {
		public static final String SYSTEM  = "ROLE_SYSTEM";
		public static final String ADMIN   = "ROLE_ADMIN";
		public static final String USER    = "ROLE_USER";
		public static final String NONE    = "ROLE_NONE";
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
