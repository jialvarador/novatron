package com.jialvarador.data.service;

import java.util.List;

import com.jialvarador.data.entity.Vehiculo;

public interface VehiculoService {

	public void add(Vehiculo vehiculo);

	public void update(Vehiculo vehiculo);

	public List<Vehiculo> list();

	public void delete(Vehiculo vehiculo);

	public Vehiculo geVehiculoById(int id);
}
