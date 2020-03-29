package com.jialvarador.data.dao;

import com.jialvarador.data.entity.Autor;

import java.util.List;

public interface AutorDAO {

    public void add(Autor autor);

    public void update(Autor autor);

    public List<Autor> actorList();

    public void delete(Autor autor);

    public Autor getActorById(int id);
}
