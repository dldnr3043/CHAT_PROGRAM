package com.ldu.chat.jpa.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * User Entity
 * 
 * jpa는 기본생성자를 요구
 * ㄴ @Entity에는 기본생성자 자동 생성이 있음
 * ㄴ 그런데도 @NoArgsConstructor를 사용하는 이유는 접근제어를 하기 위해
 * ㄴ 접근제어 이유는 데이터 영속성(real db data & entity 일관성)을 위해 -> 그래서 @Setter가 아닌 @Builder 사용
 * ㄴ 접근제어가 private이 아니고 protected인 이유는 jpa가 받아들이는 최대 수준 생성자이기 때문
 * ㄴ @AllArgsConstructor를 사용하지 않으면 @NoArgsConstructor 접근제어 때문에 @Builder에서 에러
 * ㄴ 그래서 @AllArgsConstructor 사용
 * 
 * @author ldu
 *
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="TB_USER")
public class ChatJpaUserEntity implements Serializable {
	
	private static final long serialVersionUID = -2168393822824485794L;
	
	@Id
	private String userEmail;		// 사용자 email
	private String custChannelId;	// 고객사id
	private String userName;		// 사용자명
	private String userPassword;	// 비밀번호
	@ColumnDefault("USER")
	private String authCd;			// 사용자권한 (ADMIN, USER)
	@ColumnDefault("Y")
	private String useYn;			// 사용여부
	@ColumnDefault("N")
	private String loginYn;			// 로그인여부
	
	
	@CreationTimestamp
	private LocalDateTime regDate;	// 생성일시
	@UpdateTimestamp
	private LocalDateTime updDate;	// 수정일시
	
	@Transient
    private Collection<? extends GrantedAuthority> authorities;
	
	public void grantAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
