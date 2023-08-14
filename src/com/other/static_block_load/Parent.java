package com.other.static_block_load;

public abstract class Parent {

	static {
		System.out.println("Static block from Parent");
	}
	
	protected abstract void sayHello();
}
