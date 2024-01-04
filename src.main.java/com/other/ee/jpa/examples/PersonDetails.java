package com.other.ee.jpa.examples;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PersonDetails {

	@Id @GeneratedValue
	private int id;
	private String description;
	@Enumerated(EnumType.STRING)
	private Color favouriteColor;
	@OneToOne(mappedBy = "details")
	private Person person;
	
	public PersonDetails() {
		super();
	}

	public PersonDetails(String description, Color favouriteColor, Person person) {
		super();
		this.description = description;
		this.favouriteColor = favouriteColor;
		this.person = person;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Color getFavouriteColor() {
		return favouriteColor;
	}

	public void setFavouriteColor(Color favouriteColor) {
		this.favouriteColor = favouriteColor;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "PersonDetails [id=" + id + ", description=" + description + ", favouriteColor=" + favouriteColor
				+ ", person=" + person + "]";
	}
}
