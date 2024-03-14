package com.other.spring_fast.chapter_4.comment_service.repositories;

import com.other.spring_fast.chapter_4.comment_service.models.Comment;

public interface CommentRepository {

	void storeComment(Comment comment);
}
