package com.other.network.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainServer {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(5082);
			GreetingImpl greetingRMI = new GreetingImpl();
			Naming.rebind("rmi://localhost:5082/greeting", greetingRMI);
			System.out.println("Server started");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
