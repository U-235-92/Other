package com.other.app;

import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MessageSender {
	
	private final RabbitTemplate template;
	
	@GetMapping("/direct/{color}")
	public ResponseEntity<String> sendMessage(@PathVariable String color) {
		String message = "Hello, " + color + "!";
		template.convertAndSend(SenderConfiguration.EXCHANGE_NAME, color, message);
		return ResponseEntity.of(Optional.of("200 OK"));
	}
}
