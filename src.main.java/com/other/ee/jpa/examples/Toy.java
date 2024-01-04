package com.other.ee.jpa.examples;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Toy {

	@Id
	@GeneratedValue
	private int id;
	private String description;
	
	public Toy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Toy(String description) {
		super();
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Toy [id=" + id + ", description=" + description + "]";
	}
}
