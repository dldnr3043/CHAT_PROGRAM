package com.ldu.chat.web.custchannel.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ldu.chat.jpa.permissionrequest.entity.ChatJpaPermissionRequestEntity;
import com.ldu.chat.jpa.permissionrequest.repository.ChatJpaPermissionRequestRepository;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatWebCustChannelRestController {
	
	private final ChatJpaPermissionRequestRepository chatJpaPermissionRequestRepository;

	/**
	 * 권한 요청 보내기
	 * 
	 * @param jsonParams
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value="권한 요청 보내기", notes="권한 요청 보내기")
    @PostMapping("/api/chat/cust-channel/processSendPermissionRequest")
    public Object processSendPermissionRequest(@RequestBody JSONObject jsonParams) throws Exception
    {
    	JSONObject jsonReturnParams = new JSONObject();
    	
    	ChatJpaPermissionRequestEntity chatJpaPermissionRequestEntity = ChatJpaPermissionRequestEntity.builder()
    																								  .userEmail(jsonParams.getString("USER_EMAIL"))
    																								  .custChannelId(jsonParams.getString("CUST_CHANNEL_ID"))
    																								  .build();
    	ChatJpaPermissionRequestEntity result = chatJpaPermissionRequestRepository.save(chatJpaPermissionRequestEntity);
    	
    	if(result != null) {
    		jsonReturnParams.put("ERROR_FLAG", false);
    	}
    	else {
    		jsonReturnParams.put("ERROR_FLAG", true);
    	}
    	
        //최종결과값 반환
        return jsonReturnParams;
    }
}
