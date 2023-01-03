
package com.ldu.chat.jpa.user.utils;

import java.io.Serializable;

import lombok.Data;

@Data
public class ChatJpaUserPk implements Serializable {
	private static final long serialVersionUID = -916755351467335800L;
	
	private String userEmail;
	private String custChannelId;
}
