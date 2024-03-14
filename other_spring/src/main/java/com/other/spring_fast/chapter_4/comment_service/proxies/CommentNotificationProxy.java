package com.other.spring_fast.chapter_4.comment_service.proxies;

import com.other.spring_fast.chapter_4.comment_service.models.Comment;

public interface CommentNotificationProxy {

	void sendComment(Comment comment);
}
