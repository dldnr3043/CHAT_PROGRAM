package com.ldu.chat.jpa.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	private String userId;			// �����id
	private String userName;		// ����ڸ�
	private String userPassword;	// ����ں�й�ȣ
	
	@CreationTimestamp
	private LocalDateTime regDate;	// ����Ͻ�
	@UpdateTimestamp
	private LocalDateTime updDate;	// �����Ͻ�
}
