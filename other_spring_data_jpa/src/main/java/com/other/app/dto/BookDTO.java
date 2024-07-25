package com.other.app.dto;

import com.other.app.entity.BookType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO extends ItemDTO {
	
	private String author;
	private BookType bookType;
}
