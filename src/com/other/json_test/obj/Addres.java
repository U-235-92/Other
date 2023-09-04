package com.other.json_test.obj;

public class Addres {

	private String country;
	private String city;
	private String street;
	private String zip;
	
	public Addres() {
		super();
	}

	public Addres(String country, String city, String street, String zip) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Addres [country=" + country + ", city=" + city + ", street=" + street + ", zip=" + zip + "]";
	}
}
