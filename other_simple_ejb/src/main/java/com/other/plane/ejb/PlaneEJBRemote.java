package com.other.plane.ejb;

import jakarta.ejb.Remote;
import java.util.List;

import com.other.plane.entities.Plane;

@Remote
public interface PlaneEJBRemote {

	List<Plane> getPlanes();
	Plane createPlane(Plane plane);
	void removePlane(Plane plane);
	Plane updatePlane(Plane plane);
}
