package com.jialvarador.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jialvarador.data.dao.VehiculoDAO;
import com.jialvarador.data.entity.Vehiculo;
import com.jialvarador.data.service.VehiculoService;

@Repository
public class VehiculoServiceImpl implements VehiculoService {
	

    @Autowired 
    private VehiculoDAO vehiculoDAO;


	public VehiculoDAO getVehiculoDAO() {
		return vehiculoDAO;
	}

	public void setVehiculoDAO(VehiculoDAO vehiculoDAO) {
		this.vehiculoDAO = vehiculoDAO;
	}

	@Override
	public void add(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vehiculo> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehiculo geVehiculoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
