package com.other.spring_fast.chapter_5.single.part_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		CommentService commentService1 = context.getBean("commentService", CommentService.class);
		CommentService commentService2 = context.getBean("commentService", CommentService.class);
		System.out.println(commentService1 == commentService2);
	}

}
