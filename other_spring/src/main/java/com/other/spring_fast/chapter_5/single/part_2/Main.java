package com.other.spring_fast.chapter_5.single.part_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		CommentService commentService = context.getBean(CommentService.class);
		UserService userService = context.getBean(UserService.class);
		System.out.println(userService.getCommentRepository() == commentService.getCommentRepository());
	}

}
