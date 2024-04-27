package com.other.project.main;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.other.project.config.ChatClentConfiguration;
import com.other.project.handler.SimpleWebSocketHandler;

@SpringBootApplication
public class WebSocketSimpleChatClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketSimpleChatClientApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ChatClentConfiguration.class);
		WebSocketStompClient stompClient = context.getBean(WebSocketStompClient.class);
		SimpleWebSocketHandler handler = context.getBean(SimpleWebSocketHandler.class);
		try {
			StompSession session = stompClient.connectAsync("ws://localhost:8080/simple-chat", handler).get();
			session.subscribe("/topic/string-chat-echo", handler);
			session.send("/app/string-chat-echo", "Hello, simple server!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
