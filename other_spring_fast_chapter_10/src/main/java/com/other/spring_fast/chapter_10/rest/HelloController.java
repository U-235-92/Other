package com.other.spring_fast.chapter_10.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {

	@GetMapping("/hello")
//	@ResponseBody
	public String hello() {
		return "Hello!";
	}
	
	@GetMapping("/ciao")
//	@ResponseBody
	public String ciao() {
		return "Ciao!";
	}
}
