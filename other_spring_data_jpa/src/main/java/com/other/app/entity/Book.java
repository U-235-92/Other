package com.other.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book extends Item {

	@Id
	@GeneratedValue
	private long id;
	private String author;
	@Enumerated(EnumType.STRING)
	private BookType bookType;
}
