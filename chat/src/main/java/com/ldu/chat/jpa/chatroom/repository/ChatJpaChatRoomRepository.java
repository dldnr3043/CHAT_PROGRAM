package com.ldu.chat.jpa.chatroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ldu.chat.jpa.chatroom.entity.ChatJpaChatRoomEntity;

/**
 * ChatRoomRepository
 * 
 * @author ldu
 *
 */
public interface ChatJpaChatRoomRepository extends JpaRepository<ChatJpaChatRoomEntity, String> {
	List<ChatJpaChatRoomEntity> findAllByUserEmail(String userEmail);
}
