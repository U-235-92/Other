package com.other.spring_fast.chapter_4.comment_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.other.spring_fast.chapter_4.comment_service.models.Comment;
import com.other.spring_fast.chapter_4.comment_service.proxies.CommentNotificationProxy;
import com.other.spring_fast.chapter_4.comment_service.repositories.CommentRepository;

@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final CommentNotificationProxy commentNotificationProxy;
	
	@Autowired
	public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
		super();
		this.commentRepository = commentRepository;
		this.commentNotificationProxy = commentNotificationProxy;
	}
	
	public void publishComment(Comment comment) {
		commentRepository.storeComment(comment);
		commentNotificationProxy.sendComment(comment);
	}
}
