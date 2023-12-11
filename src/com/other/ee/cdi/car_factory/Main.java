package com.other.ee.cdi.car_factory;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer weldContainer = weld.initialize();
		CarFactory carFactory = weldContainer.select(CarFactory.class).get();
		Car car = carFactory.makeCar("Toyota", "Supra", 340, 250);
		System.out.println(car);
		weld.shutdown();
	}
}
