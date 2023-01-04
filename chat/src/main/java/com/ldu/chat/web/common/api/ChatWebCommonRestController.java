package com.ldu.chat.web.common.api;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ldu.chat.jpa.custchannel.entity.ChatJpaCustChannelEntity;
import com.ldu.chat.jpa.custchannel.repository.ChatJpaCustChannelRepository;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatWebCommonRestController {
	
	private final ChatJpaCustChannelRepository chatJpaCustChannelRepository;

	/**
	 * 고객사리스트 조회
	 * 
	 * @param jsonParams
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value="고객사리스트 조회", notes="고객사리스트 조회")
    @PostMapping("/api/chat/common/selectAllUsedCustChannel")
    public Object selectAllUsedCustChannel(@RequestBody JSONObject jsonParams) throws Exception
    {
    	JSONObject jsonReturnParams = new JSONObject();
    	
    	List<ChatJpaCustChannelEntity> custChannelList = chatJpaCustChannelRepository.findAllByUseYn("Y");
    	
    	if(custChannelList != null) {
    		jsonReturnParams.put("ERROR_FLAG", false);
    		jsonReturnParams.put("DATA", custChannelList);
    	}
    	else {
    		jsonReturnParams.put("ERROR_FLAG", true);
    	}
    		
    	
        //최종결과값 반환
        return jsonReturnParams;
    }
}
