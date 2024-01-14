package com.other.plane.main;

import javax.naming.Context;
import javax.naming.NamingException;

import com.other.plane.ejb.PlaneEJB;

import jakarta.ejb.embeddable.EJBContainer;

public class PlaneApp {

	//doesn't work [java.lang.RuntimeException: EJB Container initialization error]
	public static void main(String[] args) {
		try(EJBContainer containerEJB = EJBContainer.createEJBContainer()) {
			Context context = containerEJB.getContext();
			PlaneEJB planeEJB = (PlaneEJB) context.lookup("java:global/classes/PlaneEJB!com.other.plane.ejb.PlaneEJB");
			planeEJB.getPlanes().forEach(System.out::println);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
