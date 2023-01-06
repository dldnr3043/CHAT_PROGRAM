package com.ldu.chat.jpa.permissionrequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldu.chat.jpa.permissionrequest.entity.ChatJpaPermissionRequestEntity;

/**
 * PermissionRequestRepository
 * 
 * @author ldu
 *
 */
@Repository
public interface ChatJpaPermissionRequestRepository extends JpaRepository<ChatJpaPermissionRequestEntity, String> {
}
