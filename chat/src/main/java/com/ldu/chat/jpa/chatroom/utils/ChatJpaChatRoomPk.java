package com.ldu.chat.jpa.chatroom.utils;

import java.io.Serializable;

import lombok.Data;

@Data
public class ChatJpaChatRoomPk implements Serializable {
	private static final long serialVersionUID = -8021964835324784019L;
	
	private String chatRoomId;
	private String userEmail;
}
