package com.other.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GreetingRMI extends Remote {

	public String sayHello(String name) throws RemoteException;
}
