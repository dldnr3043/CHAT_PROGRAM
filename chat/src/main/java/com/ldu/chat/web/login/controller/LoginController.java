package com.ldu.chat.web.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	/**
	 * Login Page
	 * @return
	 */
	@GetMapping(value = "/login")
	public String moveLogin() {
		log.debug("moveLogin");
		return "web/login/login";
	}
}
