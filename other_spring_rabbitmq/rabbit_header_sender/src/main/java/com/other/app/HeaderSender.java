package com.other.app;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HeaderSender {

	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("/header")
	@ResponseBody
	public String sendMessage(@RequestParam String country) {
		Message message = MessageBuilder.withBody(("Hello, from " + country).getBytes()).setHeader("country", country).build();
		rabbitTemplate.send(message);
		return "Message sent successfully";
	}
}
