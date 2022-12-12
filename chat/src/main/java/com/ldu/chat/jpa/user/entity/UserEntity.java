package com.ldu.chat.jpa.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User Entity
 * 
 * @author ldu
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_USER", schema="CHAT")
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String userId;			// 사용자id
	private String userName;		// 사용자명
	private String userPassword;	// 비밀번호
	private String authCd;			// 사용자권한 (ADMIN, USER)
	private String useYn;			// 사용여부
	
	@CreationTimestamp
	private LocalDateTime regDate;	// 생성일시
	@UpdateTimestamp
	private LocalDateTime updDate;	// 수정일시
	
	@Transient
    private Collection<? extends GrantedAuthority> authorities;
}
