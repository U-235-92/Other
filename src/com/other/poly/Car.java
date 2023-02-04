package com.other.poly;

public class Car extends Vechicle implements Enginable, Machinable{

	@Override
	public void signal() {
		
		System.out.println("bep!");
	}
	
	public void func() {
		
		System.out.println("funck()");
	}
	
	public void func(String...strs) {
		
		System.out.println("funck(String...strs)");
	}

	@Override
	public void engine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public int calculate() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
