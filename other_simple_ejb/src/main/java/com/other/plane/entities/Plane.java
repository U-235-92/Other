package com.other.plane.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@NamedQuery(name = Plane.FIND_ALL_PLANES, query = "Select plane From Plane plane")
public class Plane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL_PLANES = "plane.find_all";
	@Id @GeneratedValue
	private int id;
	@Column(name = "plane_model")
	@NotNull @NotEmpty
	private String model;
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JoinColumn(name = "mnf_fk", nullable = false)
	@NotNull
	private Manufacturer manufacturer;
	
	public Plane() {
		super();
	}

	public Plane(String model, Manufacturer manufacturer) {
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

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	@Override
	public String toString() {
		return "Plane [id=" + id + ", model=" + model + ", manufacturer=" + manufacturer + "]";
	}
} 
