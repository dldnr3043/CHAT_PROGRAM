package com.ldu.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ldu.chat.jpa.user.entity.UserEntity;
import com.ldu.chat.jpa.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ChatApplication {
	
	public static void main(String[] args) {
//		SpringApplication.run(ChatApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(ChatApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		UserEntity user = userRepository.findByUserId("test");
		
		log.debug("test ::::::::::::: {}" , user);
	}

}
