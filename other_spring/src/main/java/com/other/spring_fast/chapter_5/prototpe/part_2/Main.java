package com.other.spring_fast.chapter_5.prototpe.part_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Comment comment = new Comment();
		CommentService commentService = context.getBean(CommentService.class);
		commentService.sendComment(comment);
	}

}
