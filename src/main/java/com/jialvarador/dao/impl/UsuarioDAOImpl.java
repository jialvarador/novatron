package com.jialvarador.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jialvarador.data.dao.UsuarioDAO;
import com.jialvarador.data.entity.TaUsuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(TaUsuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TaUsuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TaUsuario> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TaUsuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaUsuario getTaUsuarioById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
