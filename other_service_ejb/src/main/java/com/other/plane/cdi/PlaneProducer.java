package com.other.plane.cdi;

import com.other.plane.entity.Plane;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class PlaneProducer {
	
	@Produces @PlaneType(manufacturer = PlaneEnum.AIRBUS)
	private Plane a320 = new Plane("A320", PlaneEnum.AIRBUS.name());
	@Produces @PlaneType(manufacturer = PlaneEnum.AIRBUS)
	private Plane a380 = new Plane("A380", PlaneEnum.AIRBUS.name());
	@Produces @PlaneType(manufacturer = PlaneEnum.McDOUGLAS)
	private Plane dc10 = new Plane("dc10", PlaneEnum.McDOUGLAS.name());
	@Produces @PlaneType(manufacturer = PlaneEnum.TUPLOEV)
	private Plane tu144 = new Plane("tu144", PlaneEnum.TUPLOEV.name());
	@Produces @PlaneType(manufacturer = PlaneEnum.ILUSHIN)
	private Plane il62 = new Plane("il62", PlaneEnum.ILUSHIN.name());
}
