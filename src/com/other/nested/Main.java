package com.other.nested;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car("BMW");
		Car.Engine engine = car.new Engine(100);
	}

}
