package com.other.extension;

public class A {

	{
		System.out.println("Non static init A");
	}
	
	static {
		System.out.println("Static init A");
	}
	
	public A() {
		System.out.println("From A");
	}
}
