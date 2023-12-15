package com.other.exception;

public class Sub extends Abstract implements Rainable {

	public Sub() throws StormExcwption {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sub(int p) {
		
		super(p);
	}
	
	@Override
	public void event() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void storm() {
		// TODO Auto-generated method stub
		System.out.println("Storm");
	}
	
	public void sub() {
		
		try {
			
			rain();
		} catch(Exception e) {
			
			throw new RuntimeException();
		}
	}
	
	public static void main(String[] args) {
		
		Sub sub = null;
		try {
			sub = new Sub();
			sub.event();
			sub.storm();
		} catch (StormExcwption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sub.storm();
		
		Sub sub2 = new Sub(3);
		sub2.sub();
	}

}
