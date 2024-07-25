package com.other.app.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum BookType {

	CLASSIC("C"), DRAMA("D"), TECHNICAL("T");
	
	private String symbol;
	
}
