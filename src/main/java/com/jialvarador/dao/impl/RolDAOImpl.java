package com.jialvarador.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jialvarador.data.dao.RolDAO;
import com.jialvarador.data.entity.TaRol;

@Repository
public class RolDAOImpl implements RolDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(TaRol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TaRol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TaRol> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TaRol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaRol getTaRolById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
