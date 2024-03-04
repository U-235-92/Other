package com.other.spring_fast.chapter_2;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/* chapter_2 part 2.2.2
 * @Component*/
public class Parrot {

	private String name;

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
	
//	@PostConstruct
//	public void init() {
//		this.name = "Chika";
//	}
}
