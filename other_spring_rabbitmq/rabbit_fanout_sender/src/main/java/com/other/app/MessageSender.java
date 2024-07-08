package com.other.app;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MessageSender {

	private final RabbitTemplate template;
	
	@GetMapping("/hello/{name}")
	@ResponseBody
	public String sendHello(@PathVariable String name) {
		String message = "Hello " + name + "! Take a greating from Spring RabbitMQ!";
		template.convertAndSend("my_spring_hello_exchange", "", message);
		return "The message's sent";
	}
}
