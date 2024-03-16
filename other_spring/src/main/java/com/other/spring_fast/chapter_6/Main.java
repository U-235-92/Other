package com.other.spring_fast.chapter_6;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		CommentService commentService = context.getBean(CommentService.class);
		Comment comment = new Comment();
		comment.setText("Demo comment");
		comment.setAuthor("Natasha");
//		String value = commentService.publishComment(comment);
//		logger.info(value);
//		commentService.deleteComment(comment);
//		commentService.editComment(comment);
		commentService.readComment(comment);
	}

}
