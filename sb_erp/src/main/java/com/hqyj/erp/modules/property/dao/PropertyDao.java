package com.hqyj.erp.modules.property.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;
import com.hqyj.erp.modules.property.entity.ScrapProperty;

/**
 * Property Dao
 * @author: HymanHu
 * @date: 2019年11月11日
 */
@Repository
@Mapper
public interface PropertyDao {
	
	/**
	 * 获取在用资产列表
	 */
	@Select("<script>" + 
		"select * from grant_property "
		+ "<where> "
		+ "<if test='userId > 0'>"
		+ "and user_id = #{userId} "
		+ "</if>"
		+ "<if test='propertyType != \"\"'>"
		+ "and property_type = #{propertyType} "
		+ "</if>"
		+ "<if test='propertyModel != \"\"'>"
		+ "and property_model = #{propertyModel} "
		+ "</if>"
		+ "<if test='propertyName != \"\"'>"
		+ "and property_name = #{propertyName} "
		+ "</if>"
		+ "</where>"
		+ " order by grant_property_id"
		+ "</script>")
	List<GrantProperty> getGrantProperties(SearchVo searchVo);
	
	/**
	 * 根据属性查询在用资产
	 */
	@Select("select * from grant_property "
			+ "where property_name=#{propertyName} "
			+ "and property_type=#{propertyType} "
			+ "and property_model=#{propertyModel}")
	GrantProperty getGrantPropertyByAttribute(GrantProperty grantProperty);
	
	/**
	 * 插入在用资产
	 */
	@Insert("insert into grant_property (user_id, property_name, property_type,"
			+ "property_model, property_num, unit_price, total_price) "
			+ "values (#{userId}, #{propertyName}, #{propertyType}, #{propertyModel}, "
			+ "#{propertyNum}, #{unitPrice}, #{totalPrice})")
	void insertGrantProperty(GrantProperty grantProperty);
	
	/**
	 * 更新在用资产
	 */
	@Update("update grant_property set user_id=#{userId}, property_name=#{propertyName}, "
			+ "property_type=#{propertyType}, property_model=#{propertyModel}, "
			+ "property_num=#{propertyNum}, unit_price=#{unitPrice}, total_price=#{totalPrice} "
			+ "where grant_property_id=#{grantPropertyId}")
	void updateGrantProperty(GrantProperty grantProperty);
	
	/**
	 * 删除在用资产
	 */
	@Delete("delete from grant_property where grant_property_id=#{grantPropertyId}")
	void deleteGrantProperty(int grantPropertyId);

	/**
	 * 获取资产列表
	 */
	@Select("<script>" + 
			"select * from property "
			+ "<where> "
			+ "<if test='propertyType != \"\"'>"
			+ "and property_type = #{propertyType} "
			+ "</if>"
			+ "<if test='propertyModel != \"\"'>"
			+ "and property_model = #{propertyModel} "
			+ "</if>"
			+ "<if test='propertyName != \"\"'>"
			+ "and property_name = #{propertyName} "
			+ "</if>"
			+ "</where>"
			+ " order by property_id"
			+ "</script>")
	List<Property> getProperties(SearchVo searchVo);
	
	/**
	 * 根据资产id查询资产
	 */
	@Select("select * from property where propery_id=#{propertyId}")
	Property getPropertyById(int propertyId);
	
	/**
	 * 根据属性查询资产
	 */
	@Select("select * from property "
			+ "where property_name=#{propertyName} "
			+ "and property_type=#{propertyType} "
			+ "and property_model=#{propertyModel}")
	Property getPropertyByAttribute(Property property);
	
	/**
	 * 插入资产
	 */
	@Insert("insert into property(property_name, property_type, property_model, "
			+ "property_num, unit_price, total_price) "
			+ "values(#{propertyName}, #{propertyType}, #{propertyModel}, #{propertyNum}, "
			+ "#{unitPrice}, #{totalPrice})")
	void insertProperty(Property property);
	
	/**
	 * 更新资产
	 */
	@Update("update property set property_name=#{propertyName}, property_type=#{propertyType}, "
			+ "property_model=#{propertyModel}, property_num=#{propertyNum}, unit_price=#{unitPrice}, "
			+ "total_price=#{totalPrice} where property_id=#{propertyId}")
	void updateProperty(Property property);
	
	/**
	 * 插入报废资产
	 */
	@Insert("insert into scrap_property (property_name, property_type, property_model, property_num) "
			+ "values (#{propertyName}, #{propertyType}, #{propertyModel}, #{propertyNum})")
	void insertScrapProperty(ScrapProperty scrapProperty);
	
	/**
	 * 更新报废资产
	 */
	@Update("update scrap_property set property_name=#{propertyName}, property_type=#{propertyType}, "
			+ "property_model=#{propertyModel}, property_num=#{propertyNum} "
			+ "where scrap_property_id=#{scrapPropertyId}")
	void updateScrapProperty(ScrapProperty scrapProperty);
	
	/**
	 * 根据Id查询报废资产
	 */
	@Select("select * from scrap_property where scrap_property_id=#{scrapPropertyId}")
	ScrapProperty getScrapPropertyById(int scrapPropertyId);
	
	/**
	 * 根据属性查询报废资产
	 */
	@Select("select * from scrap_property " 
			+ "where property_name=#{propertyName} "
			+ "and property_type=#{propertyType} "
			+ "and property_model=#{propertyModel}")
	ScrapProperty getScrapPropertyByAttribute(ScrapProperty scrapProperty);
	
	/**
	 * 获取报废资产列表
	 */
	@Select("<script>" + 
			"select * from scrap_property "
			+ "<where> "
			+ "<if test='propertyType != \"\"'>"
			+ "and property_type = #{propertyType} "
			+ "</if>"
			+ "<if test='propertyModel != \"\"'>"
			+ "and property_model = #{propertyModel} "
			+ "</if>"
			+ "<if test='propertyName != \"\"'>"
			+ "and property_name = #{propertyName} "
			+ "</if>"
			+ "</where>"
			+ " order by scrap_property_id"
			+ "</script>")
	List<ScrapProperty> getScrapProperties(SearchVo searchVo);
}
