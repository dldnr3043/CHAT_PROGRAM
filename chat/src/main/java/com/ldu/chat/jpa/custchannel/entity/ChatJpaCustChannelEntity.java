package com.ldu.chat.jpa.custchannel.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
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
@Table(name="TB_CUST_CHANNEL")
public class ChatJpaCustChannelEntity implements Serializable {
	private static final long serialVersionUID = 7235445621609666597L;
	
	@Id
	private String custChannelId;			// 고객사id
	private String custChannelName;		    // 고객사명
	private String useYn;					// 사용여부
	
	@CreationTimestamp
	@Column(insertable=true, updatable=false)
	private LocalDateTime regDate;	// 생성일시
	@UpdateTimestamp
	@Column(insertable=true, updatable=true)
	private LocalDateTime updDate;	// 수정일시
}
