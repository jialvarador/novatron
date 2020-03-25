package com.jialvarador.data.service;

import java.util.List;

import com.jialvarador.data.entity.TaUsuario;

public interface UsuarioService {

	public void add(TaUsuario usuario);

	public void update(TaUsuario usuario);

	public List<TaUsuario> list();

	public void delete(TaUsuario rol);

	public TaUsuario getUsuarioById(int id);
}
