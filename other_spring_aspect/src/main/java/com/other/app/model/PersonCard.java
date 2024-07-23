package com.other.app.model;

import java.util.UUID;

import com.other.app.dto.PersonCardDTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class PersonCard {
	
	private String id;
	private String firstname;
	private String lastname;
	private int age;
	
	private PersonCard(String id, String firstname, String lastname, int age) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	
	public static PersonCard of(String firstname, String lastname, int age) {
		return new PersonCard(UUID.randomUUID().toString(), firstname, lastname, age);
	}
	
	public static PersonCard of(PersonCardDTO personCardDTO) {
		return new PersonCard(UUID.randomUUID().toString(), personCardDTO.getFirstname(), personCardDTO.getLastname(), personCardDTO.getAge());
	}
}
