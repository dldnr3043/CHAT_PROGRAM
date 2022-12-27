package com.ldu.chat.web.signup.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ldu.chat.jpa.user.entity.ChatJpaUserEntity;
import com.ldu.chat.jpa.user.repository.ChatJpaUserRepository;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatWebSignupRestController {
	
	@Autowired
    private final PasswordEncoder	    passwordEncoder;
	private final ChatJpaUserRepository userRepository;
	
	/**
	 * test
	 * 
	 * @param mjsonParams
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value="test", notes="test")
    @PostMapping("/api/chat/signup/process")
    public Object selectRtnPageAspCustList(@RequestBody JSONObject jsonParams) throws Exception
    {
    	JSONObject jsonReturnParams = new JSONObject();
    	String userEmail    = jsonParams.getString("USER_EMAIL");
    	String userPassword = jsonParams.getString("PASSWORD");
    	String userName     = jsonParams.getString("FIRST_NAME")
    			            + " "
    			            + jsonParams.getString("LAST_NAME");
    	
    	ChatJpaUserEntity userEntity = ChatJpaUserEntity.builder()
    													.userEmail(userEmail)
    													.userPassword(passwordEncoder.encode(userPassword))
    													.userName(userName)
    													.useYn("Y")
    													.authCd("USER")
    													.custChannelId("1")
    													.build();
    			
    	
    	userRepository.save(userEntity);
    	
    		jsonReturnParams.put("ERROR_FLAG", false);
    	
        //최종결과값 반환
        return jsonReturnParams;
    }
}
