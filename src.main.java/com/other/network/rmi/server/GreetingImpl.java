package com.other.network.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.other.network.rmi.GreetingRMI;

public class GreetingImpl extends UnicastRemoteObject implements GreetingRMI {

	private static final long serialVersionUID = 1L;

	protected GreetingImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello(String name) throws RemoteException {
		System.out.println("Hello, " + name + " (:");
		return "Hello, " + name + " (:";
	}
}
