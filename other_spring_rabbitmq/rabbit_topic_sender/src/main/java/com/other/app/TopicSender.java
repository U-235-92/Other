package com.other.app;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicSender {

	private String exchange = "my_spring_topic_exchange";
	private RabbitTemplate template;
	
	public TopicSender(RabbitTemplate template) {
		this.template = template;
	}
	
	@GetMapping("/topic")
	@ResponseBody
	public String sendMessage(@RequestParam String name, @RequestParam String route) {
		String msg = "Hello, " + name + "! Your route is " + route;
		template.convertAndSend(exchange, route, msg);
		return "Send: " + name + " | " + route;
	}



}
