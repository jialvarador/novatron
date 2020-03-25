package com.jialvarador.view.impl;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.jialvarador.data.service.UsuarioService;
import com.jialvarador.view.UsuarioView;

@ManagedBean
public class UsuarioViewImpl implements UsuarioView{
	
	 @Autowired
	  private UsuarioService usuarioService;

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
