package com.jialvarador.data.dao;

import java.util.List;

import com.jialvarador.data.entidad.Actor;

public interface ActorDao {
	
	public void add(Actor actor);

	public void update(Actor actor);

	public List<Actor> list();

	public void delete(Actor actor);

	public Actor getActorById(int id);
}
