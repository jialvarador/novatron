package com.jialvarador.data.dao;

import java.util.List;

import com.jialvarador.data.entity.Vehiculo;

public interface VehiculoDAO {

	public void add(Vehiculo vehiculo);

	public void update(Vehiculo vehiculo);

	public List<Vehiculo> list();

	public void delete(Vehiculo vehiculo);

	public Vehiculo getVehiculoById(int id);
	
}
