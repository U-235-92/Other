package com.other.spring_fast.chapter_4.comment_service.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.other.spring_fast.chapter_4.comment_service.models.Comment;

@Repository
public class DBCommentRepository implements CommentRepository {

	@Override
	public void storeComment(Comment comment) {
		System.out.println("Storing comment: " + comment.getText());
	}

}
