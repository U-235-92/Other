package com.other.spring_fast.chapter_6;

public class Comment {

	private String text;
	private String author;

	public String getText() {
		return text;
	}

	public void setText(String texxt) {
		this.text = texxt;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Comment [text=" + text + ", author=" + author + "]";
	}
}
