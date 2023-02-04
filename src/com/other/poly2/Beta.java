package com.other.poly2;

public class Beta extends Alpha {

	B b = new B();
	
	static {
		
		System.out.println("Static Beta");
	}
	
	{
		
		System.out.println("Non static Beta");
	}
	
	Beta() {
		
		System.out.println("Beta");
	}
}
