package com.ldu.chat.web.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatWebChatController {
	/**
	 * Chatting Page
	 * @return
	 */
	@GetMapping(value = "/chat/web/user/chat")
	public String moveChat() {
		log.debug("moveChat");
		return "web/chat/chat";
	}
}
