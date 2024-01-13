package com.other.plane.cdi;

import com.other.plane.entities.Manufacturer;
import com.other.plane.entities.Plane;

import jakarta.enterprise.inject.Produces;

public class EntityProducer {

	@Produces @ManufacturerMark(name = "lockheed")
	private Manufacturer lockheed = new Manufacturer("Lockheed");
	@Produces @ManufacturerMark(name = "airbus")
	private Manufacturer airbus = new Manufacturer("Airbus");
	@Produces @ManufacturerMark(name = "boeing")
	private Manufacturer boeing = new Manufacturer("Boeing");
	@Produces @ManufacturerMark(name = "ilushin")
	private Manufacturer ilushin = new Manufacturer("Ilushin");
	@Produces @PlaneMark(model = "il76")
	private Plane il76 = new Plane("IL-76", ilushin);
	@Produces @PlaneMark(model = "il62")
	private Plane il62 = new Plane("IL-62", ilushin);
	@Produces @PlaneMark(model = "c5")
	private Plane c5 = new Plane("C5", lockheed);
	@Produces @PlaneMark(model = "a320")
	private Plane a320 = new Plane("A320", airbus);
	@Produces @PlaneMark(model = "b777")
	private Plane b777 = new Plane("B-777", boeing);
}
