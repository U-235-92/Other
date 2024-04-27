package com.other.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.other.project.handler.SimpleWebSocketHandler;

@Configuration
public class ChatClentConfiguration {

	@Bean
	public WebSocketStompClient webSocketStompClient() {
		WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient webSocketStompClient = new WebSocketStompClient(webSocketClient);
		webSocketStompClient.setMessageConverter(new StringMessageConverter());
		return webSocketStompClient;
	}
	
	@Bean
	public SimpleWebSocketHandler simpleWebSocketHandler() {
		SimpleWebSocketHandler simpleWebSocketHandler = new SimpleWebSocketHandler();
		return simpleWebSocketHandler;
	}
}
