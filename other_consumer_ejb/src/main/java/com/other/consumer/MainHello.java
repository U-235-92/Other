package com.other.consumer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.other.hello.HelloEJBRemote;

//doesn't work
public class MainHello {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		HelloEJBRemote helloEJB = (HelloEJBRemote) 
				context.lookup("java:global/other_hello_ejb-0.0.1-SNAPSHOT/HelloEJB!com.other.hello.HelloEJBRemote"); 
		helloEJB.sayHello();
	}

}
