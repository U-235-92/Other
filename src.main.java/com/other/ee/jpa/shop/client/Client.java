package com.other.ee.jpa.shop.client;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_details_fk", nullable = false)
	private ClientDetails clientDetails;
	
	public Client() {
		super();
	}

	public Client(String name, int age, ClientDetails clientDetails) {
		super();
		this.name = name;
		this.age = age;
		this.clientDetails = clientDetails;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public ClientDetails getClientDetails() {
		return clientDetails;
	}
	
	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}
}
