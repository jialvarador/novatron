package com.jialvarador.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jialvarador.data.dao.RolDAO;
import com.jialvarador.data.entity.TaRol;
import com.jialvarador.data.service.RolService;

@Repository
public class RolServiceImpl implements RolService {
	

    @Autowired 
    private RolDAO rolDAO;

    
    
	public RolDAO getRolDAO() {
		return rolDAO;
	}

	public void setRolDAO(RolDAO rolDAO) {
		this.rolDAO = rolDAO;
	}

	@Override
	public void add(TaRol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TaRol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TaRol> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TaRol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaRol getRolById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
