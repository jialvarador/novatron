package com.jialvarador.data.dao;

import java.util.List;

import com.jialvarador.data.entity.TaRol;

public interface RolDAO {
	
	public void add(TaRol rol);

	public void update(TaRol rol);

	public List<TaRol> list();

	public void delete(TaRol rol);

	public TaRol getTaRolById(int id);
}
