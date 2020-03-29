package com.jialvarador.data.service.impl;

import com.jialvarador.data.dao.AutorDAO;
import com.jialvarador.data.entity.Autor;
import com.jialvarador.data.service.AutorService;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Repository
public class AutorServiceImpl implements AutorService {

    //@Autowired 
    private AutorDAO autorDAO;

    public void setActorDAO(AutorDAO autorDAO) {
        this.autorDAO = autorDAO;
    }

    @Override
    @Transactional
    public void add(Autor autor) {
        this.autorDAO.add(autor);
    }

    @Override
    @Transactional
    public void update(Autor autor) {
        this.autorDAO.update(autor);
    }

    @Override
    @Transactional
    public List<Autor> actorList() {
        return this.autorDAO.actorList();
    }

    @Override
    @Transactional
    public void delete(Autor autor) {
        this.autorDAO.delete(autor);
    }

    @Override
    @Transactional
    public Autor getAutorById(int id) {
        return autorDAO.getActorById(id);
    }
}
