package com.other.extension;

public class Main {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		C c = new C();
//		System.out.println("===");
//		B b = new B();
		try {
			Class.forName("com.other.extension.C");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
