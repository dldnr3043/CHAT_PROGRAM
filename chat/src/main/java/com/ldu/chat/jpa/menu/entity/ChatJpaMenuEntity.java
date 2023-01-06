package com.ldu.chat.jpa.menu.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name="TB_MENU")
public class ChatJpaMenuEntity implements Serializable {
	
	private static final long serialVersionUID = -1398842651571021405L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String menuId;						// 메뉴id
	private String menuUrl;						// 메뉴url
	private String upperMenuId;					// 상위메뉴id
	private int	   menuDepth;					// 메뉴depth
	
	@Column(insertable=true, updatable=false)
	private String regUserId;					// 생성자
	@Column(insertable=true, updatable=true)
	private String updUSerId;					// 수정자
	
	@CreationTimestamp
	@Column(insertable=true, updatable=false)
	private LocalDateTime regDate;				// 생성일시
	@UpdateTimestamp
	@Column(insertable=true, updatable=true)
	private LocalDateTime updDate;				// 수정일시
}
