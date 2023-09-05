package com.other.json_test.obj;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
@JsonAutoDetect(creatorVisibility = Visibility.ANY)
public class Cat {

//	@JsonProperty
	private int age;
//	@JsonProperty
	private String name;
//	@JsonProperty
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
