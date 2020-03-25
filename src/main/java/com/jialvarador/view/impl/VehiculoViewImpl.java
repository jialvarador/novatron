package com.jialvarador.view.impl;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.jialvarador.data.service.VehiculoService;
import com.jialvarador.view.VehiculoView;
@ManagedBean
public class VehiculoViewImpl implements VehiculoView {
	
	 @Autowired
	  private VehiculoService vehiculoService;

	public VehiculoService getVehiculoService() {
		return vehiculoService;
	}

	public void setVehiculoService(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String almacenar() {
		// TODO Auto-generated method stub
		return null;
	}

	 
	 
}
