package com.other.spring_fast.chapter_5.prototpe.part_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {

	@Autowired
	private CommentRepository commentRepository;
	private Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	public void processComment() {
		System.out.println("Process");
	}
	
	public void validateComment() {
		System.out.println("Validate");
	}
}
