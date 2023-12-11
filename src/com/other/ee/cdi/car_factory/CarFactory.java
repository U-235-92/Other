package com.other.ee.cdi.car_factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.other.ee.cdi.car_factory.LogProducerType.LogType;

import jakarta.inject.Inject;

public class CarFactory {

	@Inject @LogProducerType(type = LogType.FACTORY)
	private Logger logger;
	@Inject @SixSymbol
	private SerialNumberGen serialNumberGen;
	
	@Loggable
	public Car makeCar(String manufacturer, String model, int horsePower, int maxSpeed) {
		logger.log(Level.INFO, "[" + getClass().getSimpleName() + "]: " + "The process of making a car");
		String serialNumber = serialNumberGen.getSerialNumber();
		return new Car(manufacturer, serialNumber, model, horsePower, maxSpeed);
	}
}
