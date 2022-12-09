package com.ldu.chat.jpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ldu.chat.jpa.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	UserEntity findByUserId(@Param("UserId") String userId);
}
