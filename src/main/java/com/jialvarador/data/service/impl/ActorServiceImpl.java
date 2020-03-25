package com.jialvarador.data.service.impl;

import com.jialvarador.data.dao.ActorDAO;
import com.jialvarador.data.entity.Actor;
import com.jialvarador.data.service.ActorService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Repository
public class ActorServiceImpl implements ActorService {

    //@Autowired 
    private ActorDAO actorDAO;

    public void setActorDAO(ActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }

    @Override
    @Transactional
    public void addActor(Actor actor) {
        this.actorDAO.addActor(actor);
    }

    @Override
    @Transactional
    public void updateActor(Actor actor) {
        this.actorDAO.updateActor(actor);
    }

    @Override
    @Transactional
    public List<Actor> actorList() {
        return this.actorDAO.actorList();
    }

    @Override
    @Transactional
    public void deleteActor(Actor actor) {
        this.actorDAO.deleteActor(actor);
    }

    @Override
    @Transactional
    public Actor getActorById(int id) {
        return actorDAO.getActorById(id);
    }
}
