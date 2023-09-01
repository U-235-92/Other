package com.other.json_test.obj;

import java.util.Arrays;

public class Cat {

	private int age;
	private String name;
	private String[] color;
	
	public Cat() {
		super();
	}

	public Cat(int age, String name, String[] color) {
		super();
		this.age = age;
		this.name = name;
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getColor() {
		return color;
	}

	public void setColor(String[] color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cat [age=" + age + ", name=" + name + ", color=" + Arrays.toString(color) + "]";
	}
}
