package com.other.network.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.other.network.rmi.GreetingRMI;

public class MainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			GreetingRMI greetingRMI = (GreetingRMI) Naming.lookup("rmi://127.0.0.1:5082/greeting");
			System.out.println("Client try say hello...");
			String answer = greetingRMI.sayHello("Name");
			System.out.println("Server answer: " + answer);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
