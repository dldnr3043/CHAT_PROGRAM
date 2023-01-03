package com.ldu.chat.web.chat.api;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ldu.chat.jpa.chatroom.entity.ChatJpaChatRoomEntity;
import com.ldu.chat.jpa.chatroom.repository.ChatJpaChatRoomRepository;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatWebChatRestController {
	
	private final ChatJpaChatRoomRepository chatJpaChatRoomRepository;
	
	/**
	 * userId로 채팅리스트 조회
	 * 
	 * @param mjsonParams
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value="userId로 채팅리스트 조회", notes="userId로 채팅리스트 조회")
    @PostMapping("/api/chat/chat/selectRtnChatListByUserId")
    public Object selectRtnChatListByUserId(@RequestBody JSONObject jsonParams) throws Exception
    {
    	JSONObject jsonReturnParams = new JSONObject();
    	String userEmail = jsonParams.getString("USER_EMAIL");
    	
    	List<ChatJpaChatRoomEntity> chatRoomList = chatJpaChatRoomRepository.findAllByUserEmail(userEmail);
    	
    	if(chatRoomList.size() > 0) {
    		jsonReturnParams.put("ERROR_FLAG", false);
        	jsonReturnParams.put("DATA", chatRoomList);
    	}
    	else {
    		jsonReturnParams.put("ERROR_FLAG", true);
    		jsonReturnParams.put("ERROR_MSG" , "현재 조회된 데이터가 없습니다.");
    	}
    	
        //최종결과값 반환
        return jsonReturnParams;
    }
}
