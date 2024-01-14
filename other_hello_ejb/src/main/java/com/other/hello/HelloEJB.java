package com.other.hello;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless(mappedName="MySessionBean")
@LocalBean
public class HelloEJB implements HelloEJBRemote {

	@Override
	public void sayHello() {
		System.out.println("Hello, EJB!");
	}
}
