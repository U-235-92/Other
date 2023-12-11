package com.other.ee.cdi.car_factory;

@FunctionalInterface
public interface SerialNumberGen {

	public String getSerialNumber();
	
	public default char getRandomChar() {
		return (char) (65 + Math.random() * ((90 - 65) + 1));
	}
}
