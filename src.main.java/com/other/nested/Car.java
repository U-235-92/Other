package com.other.nested;

public class Car {

	private String mark;
	
	public Car(String mark) {
		super();
		this.mark = mark;
	}
	
	public class Engine {
		private int power;

		public Engine(int power) {
			super();
			this.power = power;
		}
		
		private void modify(int powerUp) {
			power += powerUp;
		}
		
		public void test() {
			System.out.println("Test " + Car.this.mark);
		}
	}
	
	public void test() {
		Engine e = new Engine(100);
		e.modify(50);
	}
}
