package com.jialvarador.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jialvarador.data.dao.ActorDAO;
import com.jialvarador.data.entity.Actor;

@Repository
public class ActorDAOImpl implements ActorDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addActor(Actor actor) {
		getSession().save(actor);
	}

	@Override
	public void updateActor(Actor article) {
		getSession().update(article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> actorList() {
		return getSession().createQuery("from Actor").list();
	}

	@Override
	public void deleteActor(Actor actor) {
		getSession().delete(actor);
	}

	@Override
	public Actor getActorById(int id) {
		return (Actor) getSession().get(Actor.class, new Integer(id));
	}

}
