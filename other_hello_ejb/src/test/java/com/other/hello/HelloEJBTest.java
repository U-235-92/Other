package com.other.hello;

import static org.junit.jupiter.api.Assertions.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.jupiter.api.Test;

import jakarta.ejb.embeddable.EJBContainer;

class HelloEJBTest {

	@Test
	void test() {
		try(EJBContainer containerEJB = EJBContainer.createEJBContainer()) {
			Context context = containerEJB.getContext();
			assertNotNull(context.lookup("java:global/classes/HelloEJB!com.other.hello.HelloEJB"));
			HelloEJB planeEJB = (HelloEJB) context.lookup("java:global/classes/HelloEJB!com.other.hello.HelloEJB");
			planeEJB.sayHello();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
