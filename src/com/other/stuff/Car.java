package com.other.stuff;

import java.io.IOException;

public class Car<T> {

	private int maxSpeed;
	private String name;
	
	public Car(int maxSpeed, String name) {
		super();
		this.maxSpeed = maxSpeed;
		this.name = name;
	}
	
	public void test() throws IOException {} 
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [maxSpeed=" + maxSpeed + ", name=" + name + "]";
	}
}
