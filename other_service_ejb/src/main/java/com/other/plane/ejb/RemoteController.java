package com.other.plane.ejb;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface RemoteController<T> {

	public void create(T obj);
	public T get(int id);
	public List<T> getList(T obj);
	public void update(T obj);
	public void delete(T obj);
}
