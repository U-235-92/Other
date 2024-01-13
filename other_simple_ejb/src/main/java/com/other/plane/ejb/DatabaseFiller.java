package com.other.plane.ejb;

import com.other.plane.cdi.ManufacturerMark;
import com.other.plane.cdi.PlaneMark;
import com.other.plane.entities.Manufacturer;
import com.other.plane.entities.Plane;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
	className = "org.apache.derby.iapi.jdbc.AutoloadedDriver",
	name = "java:global/jdbc/plane_ds",
	url = "jdbc:derby:memory:plane_db;create=true")
public class DatabaseFiller {

	@Inject @PlaneMark(model = "il76")
	private Plane il76;
	@Inject @PlaneMark(model = "il62")
	private Plane il62;
	@Inject @PlaneMark(model = "c5")
	private Plane c5;
	@Inject @PlaneMark(model = "a320")
	private Plane a320;
	@Inject @PlaneMark(model = "b777")
	private Plane b777;
	@Inject @ManufacturerMark(name = "ilushin")
	private Manufacturer ilushin;
	@Inject @ManufacturerMark(name = "lockheed")
	private Manufacturer lockheed;
	@Inject @ManufacturerMark(name = "airbus")
	private Manufacturer airbus;
	@Inject @ManufacturerMark(name = "boeing")
	private Manufacturer boeing;
	@EJB
	private PlaneEJB planeEJB;
	
	@PostConstruct
	private void fillDB() {
		planeEJB.createPlane(a320);
		planeEJB.createPlane(b777);
		planeEJB.createPlane(c5);
		planeEJB.createPlane(il62);
		planeEJB.createPlane(il76);
	}
	
	@PreDestroy
	private void clearDB() {
		planeEJB.removePlane(a320);
		planeEJB.removePlane(b777);
		planeEJB.removePlane(c5);
		planeEJB.removePlane(il62);
		planeEJB.removePlane(il76);
	}
}
