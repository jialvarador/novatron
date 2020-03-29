package com.jialvarador.data.service;

import java.util.List;

import com.jialvarador.data.entidad.Actor;
import com.jialvarador.data.entity.Autor;

public interface ActorService {

    public void add(Actor actor);

    public void update(Actor actor);

    public List<Actor> list();

    public void delete(Actor actor);

    public Autor getActorById(int id);
}
