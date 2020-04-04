package com.heshouyang.springboot.Modules.test.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heshouyang.springboot.Modules.test.dao.CountryDao;
import com.heshouyang.springboot.Modules.test.entity.City;
import com.heshouyang.springboot.Modules.test.entity.Country;
import com.heshouyang.springboot.Modules.test.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDao cd;
	
	@Override
	public Country selectCountryById(int id) {
		
		return cd.selectCountryById(id);
	}

	@Override
	public City selectCityById(int id) {
		// TODO Auto-generated method stub
		return cd.selectCityById(id);
	}

	public PageInfo<City> selectCityByCountryId(int countryId,int crrentPage,int pageSise) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(crrentPage,pageSise);
		List<City> list = cd.getCitiesByCountryId(countryId);
		return new PageInfo<City>(list);
	}

	@Override
	public Country selectCountryByName(String countryName) {
		// TODO Auto-generated method stub
		return cd.selectCountryByName(countryName);
	}
	
	//事务处理，在spring boot中，事务提供注解的方式
	//里面的属性有需要回滚，不需要回滚的属性。
	@Transactional(propagation = Propagation.REQUIRED,noRollbackFor = ArithmeticException.class)
	@Override
	public void insertCity(City city) {
		
		cd.insertCity(city);
		int i = 1/0;
	}

	@Override
	public void updateCity(City city) {
		
		cd.updateCity(city);
	}

	@Override
	public void deleteCity(int cityById) {
		cd.deleteCity(cityById);
	}
}
