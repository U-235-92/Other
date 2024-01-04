package com.other.ee.jpa.examples;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Parent {

	@Id @GeneratedValue
	private int id;
	private String parentFeature;
	
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Parent(String parentFeature) {
		super();
		this.parentFeature = parentFeature;
	}

	public String getParentFeature() {
		return parentFeature;
	}

	public void setParentFeature(String parentFeature) {
		this.parentFeature = parentFeature;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", parentFeature=" + parentFeature + "]";
	}
}
