package com.other.hello;

import javax.naming.Context;
import javax.naming.NamingException;

import jakarta.ejb.embeddable.EJBContainer;

public class HelloApp {

	//doesn't work [java.lang.RuntimeException: EJB Container initialization error]
	public static void main(String[] args) {
		try(EJBContainer containerEJB = EJBContainer.createEJBContainer()) {
			Context context = containerEJB.getContext();
			HelloEJB planeEJB = (HelloEJB) context.lookup("java:global/classes/HelloEJB!com.other.hello.HelloEJB");
			planeEJB.sayHello();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
