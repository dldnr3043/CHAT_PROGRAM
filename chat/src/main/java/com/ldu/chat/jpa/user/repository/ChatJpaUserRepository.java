package com.ldu.chat.jpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldu.chat.jpa.user.entity.ChatJpaUserEntity;

/**
 * UserRepository
 * 
 * @author ldu
 *
 */
@Repository
public interface ChatJpaUserRepository extends JpaRepository<ChatJpaUserEntity, String> {
	
}
