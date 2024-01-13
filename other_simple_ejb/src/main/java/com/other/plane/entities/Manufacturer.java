package com.other.plane.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Manufacturer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	@Column(name = "mnf_name")
	@NotNull @NotEmpty
	private String name;
	
	public Manufacturer() {
		super();
	}

	public Manufacturer(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", name=" + name + "]";
	}
}
