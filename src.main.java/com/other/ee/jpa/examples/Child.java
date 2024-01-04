package com.other.ee.jpa.examples;

import jakarta.persistence.Entity;

@Entity
public class Child extends Parent {

	private String childFeature;

	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getChildFeature() {
		return childFeature;
	}

	public void setChildFeature(String childFeature) {
		this.childFeature = childFeature;
	}

	@Override
	public String toString() {
		return "Child [childFeature=" + childFeature + "]";
	}
}
