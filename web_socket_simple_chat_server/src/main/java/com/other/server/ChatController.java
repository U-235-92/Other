package com.other.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	@MessageMapping("/string-chat-echo")
	@SendTo("/topic/string-chat-echo")
	public String handleStringMessage(String message) {
		return "[ECHO]: " + message;
	}
}
