package com.jialvarador.view.impl;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.jialvarador.data.service.RolService;

@ManagedBean
public class RolViewImpl {
	
	 @Autowired
	  private RolService rolService;

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}

	 
	 
}
