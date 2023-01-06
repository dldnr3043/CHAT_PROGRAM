package com.ldu.chat.jpa.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldu.chat.jpa.menu.entity.ChatJpaMenuEntity;

/**
 * ChatJpaMenuRepository
 * 
 * @author ldu
 *
 */
@Repository
public interface ChatJpaMenuRepository extends JpaRepository<ChatJpaMenuEntity, String> {
}
