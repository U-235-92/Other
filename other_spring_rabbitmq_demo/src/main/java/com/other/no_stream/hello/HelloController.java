package com.other.no_stream.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private HelloSender helloSender;
	
	@GetMapping("/hello")
	public void sendHello() {
		helloSender.sendHello();
	}
}
