package com.ldu.chat.jpa.custchannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldu.chat.jpa.custchannel.entity.ChatJpaCustChannelEntity;

/**
 * ChatJpaCustChannelRepository
 * 
 * @author ldu
 *
 */
@Repository
public interface ChatJpaCustChannelRepository extends JpaRepository<ChatJpaCustChannelEntity, String> {
	List<ChatJpaCustChannelEntity> findAllByUseYn(String useYn);
}
