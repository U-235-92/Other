package com.other.spring_fast.chapter_6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.other.spring_fast.chapter_6")
@EnableAspectJAutoProxy
public class ProjectConfig {

	@Bean
	public LoggingAspect aspect() {
		return new LoggingAspect();
	}
}
