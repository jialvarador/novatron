package com.jialvarador.data.service;

import com.jialvarador.data.entity.Autor;

import java.util.List;

public interface AutorService {

    public void add(Autor autor);

    public void update(Autor autor);

    public List<Autor> actorList();

    public void delete(Autor autor);

    public Autor getAutorById(int id);
}
