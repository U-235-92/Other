package com.other.plane.ejb;

import java.util.List;

import com.other.plane.entities.Plane;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
@LocalBean
public class PlaneEJB implements PlaneEJBRemote {

	@PersistenceContext(name = "plane_pu")
	private EntityManager entityManager;

	public PlaneEJB() {
		super();
	}

	@Override
	public List<Plane> getPlanes() {
		return entityManager.createNamedQuery(Plane.FIND_ALL_PLANES, Plane.class).getResultList();
	}

	@Override
	public Plane createPlane(Plane plane) {
		entityManager.persist(plane);
		return plane;
	}

	@Override
	public void removePlane(Plane plane) {
		entityManager.remove(plane);
	}

	@Override
	public Plane updatePlane(Plane plane) {
		return entityManager.merge(plane);
	}
}
