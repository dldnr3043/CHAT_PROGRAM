package com.ldu.chat.web.signup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatWebSignupController {
	/**
	 * Main Page
	 * @return
	 */
	@GetMapping(value = "/chat/web/signup")
	public String moveSignup() {
		log.debug("moveSignup");
		return "web/signup/signup";
	}
}
