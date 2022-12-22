package com.ldu.chat;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatWebRootController {

	/**
	 * Web Root Page
	 * @return
	 */
	@GetMapping(value = "/")
	public ResponseEntity<?> moveWebRoot() {
		log.debug("moveWebRoot");
		
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/chat/web/main"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}
}
