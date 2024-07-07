package com.other.no_stream.hello;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class HelloSender {

	private RabbitTemplate rabbitTemplate;
	
	public void sendHello() {
		Message message = MessageBuilder.withBody("Hello, spring rabbit_mq".getBytes()).build();
		rabbitTemplate.send(message);
		System.out.println("The message was send");
	}
}
