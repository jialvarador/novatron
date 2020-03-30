package com.jialvarador.data.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jialvarador.data.dao.CityDao;
import com.jialvarador.data.entidad.City;
import com.jialvarador.data.service.CityService;

public class CityServiceImpl implements CityService<City>{
	
	private CityDao<?> cityDao;

	public CityDao<?> getCityDao() {
		return cityDao;
	}

	public void setCityDao(CityDao<?> cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public void add(City t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(City t) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<City> list() {
		// TODO Auto-generated method stub
		return (List<City>) this.cityDao.list();
	}

	@Override
	public void delete(City t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public City getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	

}
