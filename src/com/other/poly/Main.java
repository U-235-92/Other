package com.other.poly;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Vechicle> vechicles = new ArrayList<>();
		
		Car car = new Car();
		Bus bus = new Bus();
		Cargo cargo = new Cargo();
		
		vechicles.add(car);
		vechicles.add(bus);
		vechicles.add(cargo);
		
		for(Vechicle v : vechicles) {
			
			v.signal();
		}
		
		car.func();
	}

}
