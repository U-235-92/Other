package com.other.spring_fast.chapter_6;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class CommentService {

	private Logger logger = Logger.getLogger(CommentService.class.getName());
	
	public String publishComment(Comment comment) {
		logger.info("Publishing comment:" + comment.getText());
		return "SUCCESS";
	}
	
	@ToLog
	public void deleteComment(Comment comment) {
		logger.info("Deleting comment: " + comment.getText());
	}
	
	public String editComment(Comment comment) {
		logger.info("Editing comment: " + comment.getText());
		return "EDITED";
	}
	
	@ToChain
	public String readComment(Comment comment) {
		logger.info("Reading comment: " + comment.getText());
		return "READ";
	}
}
