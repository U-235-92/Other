package com.other.ee.jpa.shop.client;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	private String country;
	private String city;
	private String street;
	private String house;
	private String zip;
	
	public Address() {
		super();
	}

	public Address(String country, String city, String street, String house, String zip) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.house = house;
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
