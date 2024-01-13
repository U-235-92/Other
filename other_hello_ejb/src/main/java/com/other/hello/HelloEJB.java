package com.other.hello;

import jakarta.ejb.Stateless;

@Stateless(mappedName="MySessionBean")
public class HelloEJB implements HelloEJBRemote {

	@Override
	public void sayHello() {
		System.out.println("Hello, EJB!");
	}
}
