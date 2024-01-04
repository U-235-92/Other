package com.other.ee.jpa.shop.client;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ClientDetails {

	@Id 
	@GeneratedValue
	private int id;
	private String favouriteColor;
	@Column(length = 8)
	private String phone;
	@Embedded
	private Address address;
	@OneToOne(mappedBy = "clientDetails")
	private Client client;
	
	public ClientDetails() {
		super();
	}

	public ClientDetails(String favouriteColor, String phone, Address address) {
		super();
		this.favouriteColor = favouriteColor;
		this.phone = phone;
		this.address = address;
	}

	public String getFavouriteColor() {
		return favouriteColor;
	}

	public void setFavouriteColor(String favouriteColor) {
		this.favouriteColor = favouriteColor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
