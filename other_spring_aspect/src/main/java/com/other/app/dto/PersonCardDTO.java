package com.other.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonCardDTO {

	@NotBlank
	@Size(max = 50)
	private String firstname;
	@NotBlank
	@Size(max = 50)
	private String lastname;
	@PositiveOrZero
	private int age;
}
