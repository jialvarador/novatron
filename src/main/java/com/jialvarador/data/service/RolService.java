package com.jialvarador.data.service;

import java.util.List;

import com.jialvarador.data.entity.TaRol;

public interface RolService {
	
	public void add(TaRol rol);

	public void update(TaRol rol);

	public List<TaRol> list();

	public void delete(TaRol rol);

	public TaRol getRolById(int id);
}
