package com.other.spring_fast.chapter_5.single.bean_load;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		System.out.println("Before retrieving the CommentService");
		CommentService commentService = context.getBean(CommentService.class);
		System.out.println("After retrieving the CommentService");
	}
}
