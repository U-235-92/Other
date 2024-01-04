package com.other.ee.jpa.examples;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@SuppressWarnings("unused")
@MappedSuperclass
public abstract class Item {

	private int id;
	private double price;
	private String description;
	
	public Item() {
		super();
	}

	public Item(int id, double price, String description) {
		super();
		this.id = id;
		this.price = price;
		this.description = description;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", price=" + price + ", description=" + description + "]";
	}
}
