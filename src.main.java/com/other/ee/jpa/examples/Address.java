package com.other.ee.jpa.examples;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	private String country;
	private String city;
	private String street;
	private String houseNumber;
	private String zip;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String country, String city, String street, String houseNumber, String zip) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
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

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", street=" + street + ", houseNumber=" + houseNumber
				+ ", zip=" + zip + "]";
	}
}
