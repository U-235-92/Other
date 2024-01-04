package com.other.ee.jpa.examples;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Person {

	@Id @GeneratedValue
	private int id;
	private String name;
	private Date birthday;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PERSON_DETAILS_FK")
	private PersonDetails details;
	
	public Person() {
		super();
	}

	public Person(String name, Date birthday, PersonDetails details) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public PersonDetails getDetails() {
		return details;
	}

	public void setDetails(PersonDetails details) {
		this.details = details;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
}
