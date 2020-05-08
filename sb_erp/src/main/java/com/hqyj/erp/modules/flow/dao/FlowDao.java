package com.hqyj.erp.modules.flow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.flow.entity.Apply;

/**
 * Flow Dao
 * @author: HymanHu
 * @date: 2019年11月11日
 */
@Repository
@Mapper
public interface FlowDao {

	/**
	 * 插入申请
	 */
	@Insert("insert into apply (apply_type, apply_status, property_name, property_type, property_model, "
			+ "property_num, unit_price, total_price, apply_user_id, approve_user_id, "
			+ "apply_date, approve_date) "
			+ "values(#{applyType}, #{applyStatus}, #{propertyName}, #{propertyType}, #{propertyModel}, "
			+ "#{propertyNum}, #{unitPrice}, #{totalPrice}, #{applyUserId}, "
			+ "#{approveUserId}, #{applyDate}, #{approveDate})")
	void insertApply(Apply apply);
	
	/**
	 * 根据查询条件获取申请列表
	 */
	@Select("<script>" + 
		"select *, ua.user_name as applyUserName, up.user_name as approveUserName from apply a "
		+ "left join user ua on a.apply_user_id = ua.user_id "
		+ "left join user up on a.approve_user_id = up.user_id "
		+ "<where> "
		+ "<if test='userId > 0'>"
		+ "and a.apply_user_id = #{userId} "
		+ "</if>"
		+ "<if test='applyType != \"\" and applyType != null'>"
		+ "and a.apply_type = #{applyType} "
		+ "</if>"
		+ "<if test='propertyType != \"\" and propertyType != null'>"
		+ "and a.property_type = #{propertyType} "
		+ "</if>"
		+ "<if test='propertyModel != \"\" and propertyModel != null'>"
		+ "and a.property_model = #{propertyModel} "
		+ "</if>"
		+ "<if test='propertyName != \"\" and propertyName != null'>"
		+ "and a.property_name = #{propertyName} "
		+ "</if>"
		+ "</where>"
		+ " order by apply_date desc"
		+ "</script>")
	List<Apply> getApplies(SearchVo searchVo);
	
	/**
	 * 根据查询条件获取申请流程列表
	 */
	@Select("<script>" + 
			"select *, ua.user_name as applyUserName, up.user_name as approveUserName from apply a "
			+ "left join user ua on a.apply_user_id = ua.user_id "
			+ "left join user up on a.approve_user_id = up.user_id "
			+ "<where> "
			+ "<if test='userId > 0'>"
			+ "and a.approve_user_id = #{userId} "
			+ "</if>"
			+ "<if test='applyType != \"\" and applyType != null'>"
			+ "and a.apply_type = #{applyType} "
			+ "</if>"
			+ "<if test='propertyType != \"\" and propertyType != null'>"
			+ "and a.property_type = #{propertyType} "
			+ "</if>"
			+ "<if test='propertyModel != \"\" and propertyModel != null'>"
			+ "and a.property_model = #{propertyModel} "
			+ "</if>"
			+ "<if test='propertyName != \"\" and propertyName != null'>"
			+ "and a.property_name = #{propertyName} "
			+ "</if>"
			+ "</where>"
			+ " order by apply_date desc"
			+ "</script>")
	List<Apply> applyFlows(SearchVo searchVo);
	
	/**
	 * 根据id查新申请
	 */
	@Select("select *, ua.user_name as applyUserName, up.user_name as approveUserName from apply a "
		+ "left join user ua on a.apply_user_id = ua.user_id "
		+ "left join user up on a.approve_user_id = up.user_id "
		+ "where a.apply_id = #{applyId}")
	Apply getApplyById(int applyId);
	
	/**
	 * 更新申请
	 */
	@Update("update apply set apply_type=#{applyType}, apply_status=#{applyStatus}, "
			+ "property_name=#{propertyName}, property_type=#{propertyType}, "
			+ "property_model=#{propertyModel}, property_num=#{propertyNum}, "
			+ "unit_price=#{unitPrice}, total_price=#{totalPrice}, "
			+ "apply_user_id=#{applyUserId}, approve_user_id=#{approveUserId}, "
			+ "apply_date=#{applyDate}, approve_date=#{approveDate}, "
			+ "approve_desc=#{approveDesc} where apply_id = #{applyId}")
	void updateApply(Apply apply);
	
	/**
	 * 删除申请
	 */
	@Delete("delete from apply where apply_id = #{applyId}")
	void deleteApply(int applyId);
}
