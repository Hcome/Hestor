package com.heshouyang.springboot.Modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.aspectj.weaver.tools.Trace;
import org.springframework.stereotype.Repository;

import com.heshouyang.springboot.Modules.test.entity.City;
import com.heshouyang.springboot.Modules.test.entity.Country;

@Repository
@Mapper
public interface CountryDao {
	/**
	 * 根据国家的id查询
	 * @param id
	 * @return
	 */
	@Select("select * from m_country where country_id=#{countryId}")
		 @Results(id = "countryResult",value = {
			 @Result(column = "country_id",property = "countryId"),
			 @Result(column = "country_id",property = "cities", javaType = List.class,
			 many = @Many(select = "com.heshouyang.springboot.Modules."+"test.dao.CountryDao.getCitiesByCountryId"))
			 })
	Country selectCountryById(int id);
	
	/**
	 * 根据id去查询国家的信息
	 * @param id
	 * @return
	 */
	@Select("select *from m_city where city_id=#{cityId}")
	City selectCityById(int id);
	
	/**
	 * 根据国家的id查询城市
	 * @param id
	 * @return
	 */
	@Select("select *from m_city where country_id=#{countryId}")
	List<City> getCitiesByCountryId(int id);
	
	/**
	 * 根据国家名字查询国家信息和及其对应的城市
	 * @param countryName
	 * @return
	 */
	@Select("select *from m_country where country_name=#{countryName}")
	@ResultMap(value = "countryResult")
 	Country selectCountryByName(String countryName);
	
	/**
	 *进行插入操作
	 * @param city
	 * @return
	 */
	@Insert("insert into m_city (city_name, local_city_name, country_id, date_created) "
			+ "values (#{cityName}, #{localCityName}, #{countryId}, #{dateCreated})")
	//返回插入的id值给前端数据
	@Options(useGeneratedKeys = true,keyColumn = "city_id",keyProperty = "cityId")
	void insertCity(City city);
	/**
	 * 更新表
	 * @param city
	 */
	@Update("update m_city set city_name=#{cityName},local_city_name=#{localCityName},"
			+ "country_id=#{countryId},date_created=#{dateCreated} where city_id=#{cityId}")
	void updateCity(City city);
	
	/**
	 * 删除数据
	 * @param cityById
	 */
	@Delete("delete from m_city where city_id=#{cityId}")
	void deleteCity(int cityById);
}
