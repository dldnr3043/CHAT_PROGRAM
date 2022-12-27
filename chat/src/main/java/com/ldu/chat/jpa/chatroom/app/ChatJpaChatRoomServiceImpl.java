package com.ldu.chat.jpa.chatroom.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ldu.chat.jpa.chatroom.entity.ChatJpaChatRoomEntity;
import com.ldu.chat.jpa.chatroom.repository.ChatJpaChatRoomRepository;

import lombok.RequiredArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequiredArgsConstructor
@Service
public class ChatJpaChatRoomServiceImpl implements ChatJpaChatRoomService {

	private final ChatJpaChatRoomRepository chatRoomRepository;
	
	@Override
	public List<ChatJpaChatRoomEntity> selectChatRoomListByUserId(String userId) {
		
		List<String> requestParams = new ArrayList<String>();
		requestParams.add(userId);
		Iterable<String> iter = requestParams;
		
		List<ChatJpaChatRoomEntity> chatRoomList = chatRoomRepository.findAllById(iter);
		
		JSONArray resultArry = new JSONArray();
		
		for(int i=0;i<chatRoomList.size();i++) {
			JSONObject jsonObject = new JSONObject();
			
			jsonObject = chatRoomList.get(i);
		}
		
		return resultList;
	}

}
