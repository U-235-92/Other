package com.other.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.other.hello.HelloEJBRemote;

public class MainHelloConsumer {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		HelloEJBRemote helloEJB = (HelloEJBRemote) 
				context.lookup("java:global/other_hello_ejb-0.0.1-SNAPSHOT/HelloEJB!com.other.hello.HelloEJBRemote");
		helloEJB.sayHello();
	}
}
