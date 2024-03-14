package com.other.spring_fast.chapter_4.comment_service.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.other.spring_fast.chapter_4.comment_service.proxies.CommentNotificationProxy;
import com.other.spring_fast.chapter_4.comment_service.proxies.EmailCommentNotificationProxy;
import com.other.spring_fast.chapter_4.comment_service.repositories.CommentRepository;
import com.other.spring_fast.chapter_4.comment_service.repositories.DBCommentRepository;
import com.other.spring_fast.chapter_4.comment_service.services.CommentService;

@Configuration
@ComponentScan(basePackages = {"com.other.spring_fast.chapter_4.comment_service.repositories", 
		"com.other.spring_fast.chapter_4.comment_service.proxies", 
		"com.other.spring_fast.chapter_4.comment_service.services"})
public class ProjectConfiguration {
	
//	@Bean
//	public CommentRepository commentRepository() {
//		return new DBCommentRepository();
//	}
//	
//	@Bean
//	public CommentNotificationProxy commentNotificationProxy() {
//		return new EmailCommentNotificationProxy();
//	}
//	
//	@Bean
//	public CommentService commentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
//		return new CommentService(commentRepository, commentNotificationProxy);
//	}
}
