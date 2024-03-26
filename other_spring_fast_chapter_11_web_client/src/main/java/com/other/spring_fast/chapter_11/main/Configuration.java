package com.other.spring_fast.chapter_11.main;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public WebClient webClient() {
		return WebClient
				.builder()
				.build();
	}
}
