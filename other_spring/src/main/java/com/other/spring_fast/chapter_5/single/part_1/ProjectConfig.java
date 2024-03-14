package com.other.spring_fast.chapter_5.single.part_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

	@Bean
	public CommentService commentService() {
		return new CommentService();
	}
}
