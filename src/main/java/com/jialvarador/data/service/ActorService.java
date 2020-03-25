package com.jialvarador.data.service;

import com.jialvarador.data.entity.Actor;

import java.util.List;

public interface ActorService {

    public void addActor(Actor actor);

    public void updateActor(Actor actor);

    public List<Actor> actorList();

    public void deleteActor(Actor actor);

    public Actor getActorById(int id);
}
