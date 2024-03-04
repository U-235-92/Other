package com.other.spring_fast.chapter_3;

import org.springframework.stereotype.Component;

//@Component
public class Parrot {

	private String name = "Mika";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Parrot [name=" + name + "]";
	}
}
