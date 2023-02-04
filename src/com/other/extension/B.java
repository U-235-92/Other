package com.other.extension;

public class B extends A {
	
	{
		System.out.println("Non static init B");
	}
	
	static {
		System.out.println("Static init B");
	}
	
	public B() {
		System.out.println("From B");
	}
}
