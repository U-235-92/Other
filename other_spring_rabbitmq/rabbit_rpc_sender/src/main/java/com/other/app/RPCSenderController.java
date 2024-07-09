package com.other.app;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RPCSenderController {

	private RabbitTemplate template;
	
	@GetMapping("/rpc/{name}")
	@ResponseBody
	public String sendTask(@PathVariable String name) {
		template.convertAndSend("task", name);
		return "The task sent seccsessfully";
	}
}
