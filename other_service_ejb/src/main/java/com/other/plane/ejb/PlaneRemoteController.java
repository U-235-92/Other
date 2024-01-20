package com.other.plane.ejb;

import java.util.List;

import com.other.plane.entity.Plane;

import jakarta.ejb.Remote;

@Remote
public interface PlaneRemoteController {

	public void create(Plane obj);
	public Plane get(int id);
	public List<Plane> getListOf(Plane obj);
	public List<Plane> getAllPlanes();
	public void update(Plane obj);
	public void delete(Plane obj);
}
