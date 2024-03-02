package com.other.producer;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;

public class Producer {

	public static void main(String[] args) throws NamingException {
		Properties prop = new Properties();
		prop.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		prop.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		prop.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
//		prop.put(Context.PROVIDER_URL, "mq://localhost:7676/");
//		prop.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
//		prop.setProperty("org.omg.CORBA.ORBInitialPort", "7676");
		Context context = new InitialContext(prop);
		Destination destination = (Destination) context.lookup("jms/other/example/destination/Topic");
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/other/example/factory/ConnectionFactory");
		try(JMSContext jmsContext = connectionFactory.createContext()) {
			JMSProducer producer = jmsContext.createProducer();
			Message message = jmsContext.createTextMessage("Hello, JMS!");
			producer.send(destination, message);
		}
	}

}
