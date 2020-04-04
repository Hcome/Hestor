package com.heshouyang.springboot.Modules.test.service;

import com.github.pagehelper.PageInfo;
import com.heshouyang.springboot.Modules.test.entity.City;
import com.heshouyang.springboot.Modules.test.entity.Country;


public interface CountryService {

	Country selectCountryById(int id);
	
	City selectCityById(int id);
	
	PageInfo<City> selectCityByCountryId(int countryId,int crrentPage,int pageSize);
	
	Country selectCountryByName(String countryName);
	
	void insertCity(City city);
	
	void updateCity(City city);
	
	void deleteCity(int cityById);
}
