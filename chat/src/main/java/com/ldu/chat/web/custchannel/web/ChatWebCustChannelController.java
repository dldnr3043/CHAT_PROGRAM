package com.ldu.chat.web.custchannel.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatWebCustChannelController {
	/**
	 * None CustChannel Page
	 * @return
	 */
	@GetMapping(value = "/chat/web/none-cust-channel")
	public String moveNoneCustChannel() {
		log.debug("moveNoneCustChannel");
		return "web/custchannel/none-cust-channel";
	}
}
