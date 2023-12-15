package com.other.ee.jpa.motorcycle;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@SuppressWarnings("unused")
@Entity
@SequenceGenerator(name = "Fnc_generator")
@NamedQueries({
	@NamedQuery(name = "selectAllMotorcycles", query = "SELECT m FROM Motorcycle m"),
	@NamedQuery(name = "selectYamahaSR400", query = "SELECT m FROM Motorcycle m WHERE m.model = 'SR400'")
})
public class Motorcycle {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	@NotMinusOrZero
	private int engine;
	@NotMinusOrZero
	private int topSpeed;
	@NotNull @NotEmpty
	private String manufacturer;
	@NotNull @NotEmpty
	private String model;
	
	public Motorcycle() {
		super();
	}

	public Motorcycle(int engine, int topSpeed, String manufacturer, String model) {
		super();
		this.engine = engine;
		this.topSpeed = topSpeed;
		this.manufacturer = manufacturer;
		this.model = model;
	}
	
	public long getId() {
		return id;
	}

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Motorcycle [id=" + id + ", engine=" + engine + ", topSpeed=" + topSpeed + ", manufacturer="
				+ manufacturer + ", model=" + model + "]";
	}
}
