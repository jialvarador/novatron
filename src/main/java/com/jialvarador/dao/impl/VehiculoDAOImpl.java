package com.jialvarador.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jialvarador.data.dao.VehiculoDAO;
import com.jialvarador.data.entity.Vehiculo;

@Repository
public class VehiculoDAOImpl implements VehiculoDAO {
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Vehiculo vehiculo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Vehiculo vehiculo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vehiculo> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Vehiculo vehiculo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vehiculo getVehiculoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
