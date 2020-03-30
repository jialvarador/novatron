package com.jialvarador.data.service;

import java.util.List;

public interface CityService<T> {
	
	

	public void add(T t);

	public void update(T t);

	public List<T> list();

	public void delete(T t);

	public T getById(int id);

}
