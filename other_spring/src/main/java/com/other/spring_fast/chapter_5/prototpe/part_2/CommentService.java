package com.other.spring_fast.chapter_5.prototpe.part_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

	@Autowired
	private ApplicationContext context;
	
	public void sendComment(Comment comment) {
		CommentProcessor commentProcessor = context.getBean(CommentProcessor.class);
		commentProcessor.setComment(comment);
		commentProcessor.processComment();
		commentProcessor.validateComment();
	}
	
}
