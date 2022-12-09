package com.ldu.chat;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ChatApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ChatApplication.class)
        .properties("spring.config.location=classpath:/application-${spring.profiles.active}.yml")
        .web(WebApplicationType.SERVLET)
        .run(args);
	}

}
