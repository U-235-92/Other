package com.other.poly2;

public class Alpha {
	
	A a2 = new A();
	
	{
		System.out.println("Non static Alpha");
	}
	
	static {
		System.out.println("Static Alpha");
	}
	
	A a = new A();
	
	Alpha(){
		
		System.out.println("Alpha");
	}
}
