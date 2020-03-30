package com.jialvarador.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jialvarador.data.dao.CityDao;

@Repository
public class CityDaoImpl<T> implements CityDao<T> {
	
	
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from City").list();
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
