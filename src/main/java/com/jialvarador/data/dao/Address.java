package com.jialvarador.data.dao;

import java.util.List;

public interface Address<T> {
	
	public void add(T t);
	public void update(T t);
	public List<T> list();
	public void delete(T t);
	public T getById(int id);
	
}
