package com.ldu.chat.jpa.friendlist.utils;

import java.io.Serializable;

import lombok.Data;

@Data
public class ChatJpaFriendListPk implements Serializable {
	private static final long serialVersionUID = -6084413328021524746L;
	
	private String userEmail;
	private String custChannelId;
	private String friendUserEmail;
	private String friendCustChannelId;
}
