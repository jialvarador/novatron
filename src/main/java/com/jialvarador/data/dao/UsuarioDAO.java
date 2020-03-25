package com.jialvarador.data.dao;

import java.util.List;

import com.jialvarador.data.entity.TaUsuario;

public interface UsuarioDAO {
	
	public void add(TaUsuario usuario);

	public void update(TaUsuario usuario);

	public List<TaUsuario> list();

	public void delete(TaUsuario usuario);

	public TaUsuario getTaUsuarioById(int id);
}
