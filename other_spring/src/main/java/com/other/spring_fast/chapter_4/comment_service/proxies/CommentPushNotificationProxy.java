package com.other.spring_fast.chapter_4.comment_service.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.other.spring_fast.chapter_4.comment_service.models.Comment;

@Component
//@Primary
@Qualifier("PUSH")
public class CommentPushNotificationProxy implements CommentNotificationProxy {

	@Override
	public void sendComment(Comment comment) {
		System.out.println("Sending push notification for comment: " + comment.getText());
	}

}
