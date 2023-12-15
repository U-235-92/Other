package com.other.ee.cdi.car_factory;

public class Car {

	private String manufacturer;
	private String serialNumber;
	private String model;
	private int horsePower;
	private int maxSpeed;
	
	public Car() {
		super();
		manufacturer = null;
		serialNumber = null;
		model = null;
		horsePower = -1;
		maxSpeed = -1;
	}
	
	public Car(String manufacturer, String serialNumber, String model, int horsePower, int maxSpeed) {
		super();
		this.manufacturer = manufacturer;
		this.serialNumber = serialNumber;
		this.model = model;
		this.horsePower = horsePower;
		this.maxSpeed = maxSpeed;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", serialNumber=" + serialNumber + ", model=" + model
				+ ", horsePower=" + horsePower + ", maxSpeed=" + maxSpeed + "]";
	}
}
