package com.other.plane.ejb;

import java.util.List;

import com.other.plane.entity.Plane;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class PlaneController implements RemoteController<Plane> {

	@PersistenceContext(name = "plane_pu")
	private EntityManager entityManager;
	
	public PlaneController() {
		super();
	}

	@Override
	public void create(Plane obj) {
		entityManager.persist(obj);
	}

	@Override
	public Plane get(int id) {
		return entityManager.find(Plane.class, id);
	}
	
	@Override
	public List<Plane> getList(Plane obj) {
		TypedQuery<Plane> typedQuery = entityManager.
				createQuery("SELECT p FROM Plane p WHERE p.model = :pmodel AND p.manufacturer = :pmanufacturer", Plane.class);
		typedQuery.setParameter("pmodel", obj.getModel());
		typedQuery.setParameter("pmanufacturer", obj.getManufacturer());
		return typedQuery.getResultList();
	}

	@Override
	public void update(Plane obj) {
		entityManager.merge(obj);
	}

	@Override
	public void delete(Plane obj) {
		entityManager.remove(obj);
	}
	
	protected void dropAll() {
		entityManager.createQuery("DELETE FROM Plane p").executeUpdate();
	}
}
