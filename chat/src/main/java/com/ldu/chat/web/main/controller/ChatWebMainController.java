package com.ldu.chat.web.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ldu.chat.web.login.controller.ChatWebLoginController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatWebMainController {
	/**
	 * Main Page
	 * @return
	 */
	@GetMapping(value = "/main")
	public String moveMain() {
		log.debug("moveMain");
		return "web/main/main";
	}
}
