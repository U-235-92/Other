package com.other.app;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {
	
	@RabbitListener(queues = "spring_topic_queue1") 
	public void queue1Listener(String message) {
		System.out.println("Received Q1: " + message) ;
	}
	
	@RabbitListener(queues = "spring_topic_queue2") 
	public void queue2Listener(String message) {
		System.out.println("Received Q2: " + message) ;
	}
}
