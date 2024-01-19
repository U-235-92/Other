package com.other.plane.entity;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Access(AccessType.FIELD)
public class Plane {

	@Id @GeneratedValue @Column(name = "plane_id")
	private int id;
	@Column(name = "plane_model")
	private String model;
	@Column(name = "plane_manufacturer")
	private String manufacturer;
	
	public Plane() {
		super();
	}

	public Plane(String model, String manufacturer) {
		super();
		this.model = model;
		this.manufacturer = manufacturer;
	}

	public int getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	@Override
	public String toString() {
		return "Plane [id=" + id + ", model=" + model + ", manufacturer=" + manufacturer + "]";
	}
}
