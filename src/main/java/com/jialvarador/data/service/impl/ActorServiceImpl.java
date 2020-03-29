package com.jialvarador.data.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jialvarador.data.dao.ActorDao;
import com.jialvarador.data.dao.AutorDAO;
import com.jialvarador.data.entidad.Actor;
import com.jialvarador.data.entity.Autor;
import com.jialvarador.data.service.ActorService;

public class ActorServiceImpl implements ActorService {
	 
	private ActorDao actorDao;

   
    
    
	public ActorDao getActorDao() {
		return actorDao;
	}

	public void setActorDao(ActorDao actorDao) {
		this.actorDao = actorDao;
	}

	@Override
	public void add(Actor actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Actor actor) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<Actor> list() {
		return this.actorDao.list();
	}

	@Override
	public void delete(Actor actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public Autor getActorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
