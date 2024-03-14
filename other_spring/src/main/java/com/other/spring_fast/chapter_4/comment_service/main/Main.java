package com.other.spring_fast.chapter_4.comment_service.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.other.spring_fast.chapter_4.comment_service.models.Comment;
import com.other.spring_fast.chapter_4.comment_service.proxies.CommentNotificationProxy;
import com.other.spring_fast.chapter_4.comment_service.proxies.EmailCommentNotificationProxy;
import com.other.spring_fast.chapter_4.comment_service.repositories.CommentRepository;
import com.other.spring_fast.chapter_4.comment_service.repositories.DBCommentRepository;
import com.other.spring_fast.chapter_4.comment_service.services.CommentService;

public class Main {

	public static void main(String[] args) {
//		CommentRepository commentRepository = new DBCommentRepository();
//		CommentNotificationProxy commentNotificationProxy = new EmailCommentNotificationProxy();
//		CommentService commentService = new CommentService(commentRepository, commentNotificationProxy);
//		Comment comment = new Comment();
//		comment.setAuthor("John");
//		comment.setText("Demo comment");
//		commentService.publishComment(comment);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		Comment comment = new Comment();
		comment.setAuthor("John");
		comment.setText("Demo comment");
		CommentService commentService = context.getBean(CommentService.class);
		commentService.publishComment(comment);
	}

}
