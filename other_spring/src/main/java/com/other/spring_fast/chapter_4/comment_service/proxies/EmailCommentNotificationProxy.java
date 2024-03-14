package com.other.spring_fast.chapter_4.comment_service.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.other.spring_fast.chapter_4.comment_service.models.Comment;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

	@Override
	public void sendComment(Comment comment) {
		System.out.println("Sending notificaation for comment: " + comment.getText());
	}

}
