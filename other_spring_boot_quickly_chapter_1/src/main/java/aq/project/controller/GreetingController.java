package aq.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aq.project.property.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	@Autowired
	private Greeting greeting;
	
	@GetMapping
	String getGreeting() {
		return greeting.getName();
	}
	
	@GetMapping("/coffee") 
	String getNameAndCoffee() {
		return greeting.getCoffee();
	}
}
