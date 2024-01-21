package com.other.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.other.plane.ejb.PlaneRemoteController;
import com.other.plane.entity.Plane;

public class ClientApp {

	public static void main(String[] args) throws NamingException {
		Properties prop = new Properties();
		prop.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		prop.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		prop.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		Context context = new InitialContext(prop);
		PlaneRemoteController planeController = (PlaneRemoteController) 
				context.lookup("java:global/other_service_ejb/PlaneController!com.other.plane.ejb.PlaneRemoteController");
		System.out.println(planeController.getAllPlanes());
		Plane tu144 = new Plane("Tu144", "Tupolev");
		planeController.create(tu144);
		System.out.println(planeController.getAllPlanes());
	}

}
