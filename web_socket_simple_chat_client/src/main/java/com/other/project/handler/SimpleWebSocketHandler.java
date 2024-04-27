package com.other.project.handler;

import java.lang.reflect.Type;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class SimpleWebSocketHandler extends StompSessionHandlerAdapter {

	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
//		session.subscribe("/topic/string-chat-echo", this);
//		session.send("/app/string-chat-echo", "Hello, simple server!");
	}
	
	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		System.out.println(payload);
	}
	
}
