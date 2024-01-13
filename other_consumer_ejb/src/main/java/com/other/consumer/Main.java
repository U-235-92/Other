package com.other.consumer;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.other.hello.HelloEJBRemote;

public class Main {

	public static void main(String[] args) throws NamingException {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		Context context = new InitialContext(properties);
		HelloEJBRemote helloEJB = (HelloEJBRemote) 
				context.lookup("java:global/other_hello_ejb-0.0.1-SNAPSHOT/HelloEJB!com.other.hello.HelloEJBRemote"); 
		helloEJB.sayHello();
	}

}
