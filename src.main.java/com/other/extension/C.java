package com.other.extension;

public class C extends B {

	{
		System.out.println("Non static init B");
	}
	
	public C() {
		System.out.println("From C");
	}
}
