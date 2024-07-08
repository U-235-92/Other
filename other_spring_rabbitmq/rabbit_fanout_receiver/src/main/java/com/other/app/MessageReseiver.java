package com.other.app;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReseiver {
	
	@RabbitListener(queues = "spring_hello_queue_1")
	public void receiveMessage(String message) {
		System.out.println("Received: " + message);
	}
	
}
