package com.jialvarador.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jialvarador.data.dao.ActorDao;
import com.jialvarador.data.entidad.Actor;

@Repository
public class ActorDaoImpl implements ActorDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void add(Actor actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Actor actor) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> list() {
		return getSession().createQuery("from actor").list();
	}

	@Override
	public void delete(Actor actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public Actor getActorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
