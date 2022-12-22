package com.ldu.chat.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("project")
public class ChatProjectConfig {
	private String serviceUrl;
	private String publicUrl;
	private String mainPath;
	private String loginPath;
	private String logoutPath;
}
