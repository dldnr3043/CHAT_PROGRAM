package com.ldu.chat.jpa.custchannel.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;

import com.ldu.chat.jpa.user.entity.ChatJpaUserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CustChannel Entity
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
@Table(name="TB_CUST_CHANNEL", schema="CHAT")
public class ChatJpaCustChannelEntity {
	@Id
	private String custChannelId;			// 고객사id
	private String custChannelName;		    // 고객사명
	private String useYn;					// 사용여부
	
	@CreationTimestamp
	private LocalDateTime regDate;	// 생성일시
	@UpdateTimestamp
	private LocalDateTime updDate;	// 수정일시
}
