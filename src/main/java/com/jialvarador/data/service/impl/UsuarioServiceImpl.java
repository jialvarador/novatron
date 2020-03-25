package com.jialvarador.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jialvarador.data.dao.UsuarioDAO;
import com.jialvarador.data.entity.TaUsuario;
import com.jialvarador.data.service.UsuarioService;

@Repository
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public void add(TaUsuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(TaUsuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TaUsuario> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TaUsuario rol) {
		// TODO Auto-generated method stub

	}

	@Override
	public TaUsuario getUsuarioById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
