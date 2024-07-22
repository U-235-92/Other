package com.other.app.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book extends Item {
	
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String title;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String author;
}
