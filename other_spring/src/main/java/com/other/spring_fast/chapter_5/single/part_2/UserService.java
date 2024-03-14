package com.other.spring_fast.chapter_5.single.part_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private CommentRepository commentRepository;

	public CommentRepository getCommentRepository() {
		return commentRepository;
	}
	
}
