package com.other.spring_fast.chapter_13.transaction.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.other.spring_fast.chapter_13.transaction.repository", 
		"com.other.spring_fast.chapter_13.transaction.controller",
		"com.other.spring_fast.chapter_13.transaction.service"})
public class OtherSpringFastChapter13Application {

	public static void main(String[] args) {
		SpringApplication.run(OtherSpringFastChapter13Application.class, args);
	}

}
