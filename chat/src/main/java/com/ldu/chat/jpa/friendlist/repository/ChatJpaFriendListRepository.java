package com.ldu.chat.jpa.friendlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldu.chat.jpa.friendlist.entity.ChatJpaFriendListEntity;

/**
 * ChatJpaFriendListRepository
 * 
 * @author ldu
 *
 */
@Repository
public interface ChatJpaFriendListRepository extends JpaRepository<ChatJpaFriendListEntity, String> {
}
