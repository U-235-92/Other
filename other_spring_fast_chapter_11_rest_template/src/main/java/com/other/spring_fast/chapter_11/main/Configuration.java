package com.other.spring_fast.chapter_11.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {"com.other.spring_fast.chapter_11.proxy", "com.other.spring_fast.chapter_11.controller"})
public class Configuration {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
