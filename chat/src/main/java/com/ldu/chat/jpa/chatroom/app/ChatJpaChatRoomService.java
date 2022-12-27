package com.ldu.chat.jpa.chatroom.app;

import java.util.List;

import com.ldu.chat.jpa.chatroom.entity.ChatJpaChatRoomEntity;

public interface ChatJpaChatRoomService {
	List<ChatJpaChatRoomEntity> selectChatRoomListByUserId(String userId);
}
