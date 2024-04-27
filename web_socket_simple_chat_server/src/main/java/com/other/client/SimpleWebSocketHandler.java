package com.other.client;

import java.lang.reflect.Type;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class SimpleWebSocketHandler extends StompSessionHandlerAdapter {
	
	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		System.out.println(payload);
	}
	
	@Override
	public Type getPayloadType(StompHeaders headers) {
		return String.class;
	}
}
