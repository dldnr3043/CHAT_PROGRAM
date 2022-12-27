package com.ldu.chat.web.chat.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ldu.chat.jpa.chatroom.app.ChatJpaChatRoomService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatWebChatRestController {
	
	private final ChatJpaChatRoomService chatJpaChatRoomService;
	
	/**
	 * userId로 채팅리스트 조회
	 * 
	 * @param mjsonParams
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value="userId로 채팅리스트 조회", notes="userId로 채팅리스트 조회")
    @PostMapping("/api/chat/chat/selectChatListByUserId")
    public Object selectChatListByUserId(@RequestBody JSONObject jsonParams) throws Exception
    {
    	JSONObject jsonReturnParams = new JSONObject();
    	String userId = jsonParams.getString("USER_ID");
    	
    	chatJpaChatRoomService.selectChatRoomListByUserId(userId);
    	
        //최종결과값 반환
        return jsonReturnParams;
    }
}
