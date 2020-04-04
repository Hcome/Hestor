package com.heshouyang.springboot.Modules.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.heshouyang.springboot.Modules.test.entity.City;
import com.heshouyang.springboot.Modules.test.entity.Country;
import com.heshouyang.springboot.Modules.test.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	private CountryService cs;
	
	//http://127.0.0.1:8088/country/522
	@RequestMapping(value = "/country/{countryId}",method = RequestMethod.GET)
	public Country findByCountryId(@PathVariable int countryId) {
		
		return cs.selectCountryById(countryId);
	}
	//http://127.0.0.1:8088/city/1911
	@RequestMapping("/city/{id}")
	public City selectCityById(@PathVariable int id) {
		
		return cs.selectCityById(id);
	}
	/**
	 * 后端的分页插件，带参数的接口返回前端页面
	 * @param id
	 * @param crentPage
	 * @param pageSize
	 * @return
	 */
	//http://127.0.0.1:8088/countryId?id=522&crentPage=1&pageSize=6
	@RequestMapping("/countryId")
	public PageInfo<City> selectCityByCountryId(@RequestParam int id,@RequestParam int crentPage,@RequestParam int pageSize) {
		
		PageInfo<City> cities = cs.selectCityByCountryId(id, crentPage, pageSize);	
		return cities;
	}
	
	//http://127.0.0.1:8088/countryName
	@RequestMapping("/countryName")
	public Country selectCountryByName(@RequestParam String name) {
				
		return cs.selectCountryByName(name);
	}
	
	//http://127.0.0.1:8088/city
	//@RequestBody接收json字符串的注解
	@PostMapping(value = "/city",consumes = "application/json")
	//@ModelAttribute接收form表单的方式
	public City insertCity(@RequestBody City city) {
		cs.insertCity(city);
		return city;
	}
	//http://127.0.0.1:8088/updateCity
	//路径一致但是请求方式不同可以存在
	@PutMapping(value = "/city",consumes = "application/x-www-form-urlencoded")
	public City updateCity(@ModelAttribute City city) {
		cs.updateCity(city);
		return city;
	}
	
	//http://127.0.0.1:8088/cities/2253
	@DeleteMapping(value = "/cities/{cityId}")
	public void deleteById(@PathVariable("cityId") int cityId) {
		cs.deleteCity(cityId);
	}
}
