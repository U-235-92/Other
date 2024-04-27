package com.other.client;

import java.time.Instant;
import java.util.concurrent.ExecutionException;

import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

public class ClientTwo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient webSocketStompClient = new WebSocketStompClient(webSocketClient);
		webSocketStompClient.setMessageConverter(new StringMessageConverter());
		SimpleWebSocketHandler simpleWebSocketHandler = new SimpleWebSocketHandler();
		StompSession session = webSocketStompClient.connectAsync("ws://localhost:8080/simple-chat", simpleWebSocketHandler).get();
		session.subscribe("/topic/string-chat-echo", simpleWebSocketHandler);
		while(true) {
			Thread.sleep(1000);
			session.send("/app/string-chat-echo", "[Client Two]: Hello, simple server!" + Instant.now().getEpochSecond());
		}
	}

}
