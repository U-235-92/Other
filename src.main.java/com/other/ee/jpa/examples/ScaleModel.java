package com.other.ee.jpa.examples;

import jakarta.persistence.Entity;

@Entity
public class ScaleModel extends Item {

	private String manufacturer;
	private String name;
	
	public ScaleModel() {
		super();
	}

	public ScaleModel(String manufacturer, String name) {
		super();
		this.manufacturer = manufacturer;
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ScaleModel [manufacturer=" + manufacturer + ", name=" + name + ", price=" + getPrice() + ", id=" + getId() + "]";
	}
}
