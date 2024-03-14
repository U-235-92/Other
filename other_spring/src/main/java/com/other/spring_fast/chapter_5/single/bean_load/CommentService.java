package com.other.spring_fast.chapter_5.single.bean_load;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;

@Service
@Lazy
public class CommentService {

	public CommentService() {
		System.out.println("CommentService instance created!");
	}

	
}
