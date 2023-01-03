package com.ldu.chat.jpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	@Query("select user "
		   + "from ChatJpaUserEntity user "
		   + "where user.custChannelId = :custChannelId "
		   + "and user.userEmail = :userEmail")
	ChatJpaUserEntity selectUserEntity(@Param("custChannelId") String custChannelId, @Param("userEmail") String userEmail);
}
