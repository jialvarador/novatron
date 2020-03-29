package com.jialvarador.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jialvarador.data.dao.AutorDAO;
import com.jialvarador.data.entity.Autor;

@Repository
public class AutorDAOImpl implements AutorDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Autor autor) {
		getSession().save(autor);
	}

	@Override
	public void update(Autor article) {
		getSession().update(article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Autor> actorList() {
		return getSession().createQuery("from Autor").list();
	}

	@Override
	public void delete(Autor autor) {
		getSession().delete(autor);
	}

	@Override
	public Autor getActorById(int id) {
		return (Autor) getSession().get(Autor.class, new Integer(id));
	}

}
