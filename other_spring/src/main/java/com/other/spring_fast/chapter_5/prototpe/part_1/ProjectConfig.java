package com.other.spring_fast.chapter_5.prototpe.part_1;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProjectConfig {

	@Bean
	@Scope(scopeName = BeanDefinition.SCOPE_PROTOTYPE)
	public CommentService commentService() {
		return new CommentService();
	}
}
