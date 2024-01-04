package com.other.ee.jpa.examples;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class House {
	
	@Id @GeneratedValue
	private int id;
	private int square;
	private int numberOfFloor;
	@Embedded
	private Address address;
	
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	public House(int square, int numberOfFloor, Address address) {
		super();
		this.square = square;
		this.numberOfFloor = numberOfFloor;
		this.address = address;
	}

	public int getSquare() {
		return square;
	}

	public void setSquare(int square) {
		this.square = square;
	}

	public int getNumberOfFloor() {
		return numberOfFloor;
	}

	public void setNumberOfFloor(int numberOfFloor) {
		this.numberOfFloor = numberOfFloor;
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

	@Override
	public String toString() {
		return "House [id=" + id + ", square=" + square + ", numberOfFloor=" + numberOfFloor + ", address=" + address
				+ "]";
	}
}
