package com.hqyj.erp.modules.organization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.entity.Position;
import com.hqyj.erp.modules.organization.vo.ZtreeModel;

/**
 * Organization Dao
 * @author: HymanHu
 * @date: 2019年11月11日
 */
@Repository
@Mapper
public interface OrganizationDao {
	
	/**
	 * 获取部门列表
	 */
	@Select("select * from department")
	List<Department> getDepartments();

	/**
	 * 根据部门id查询部门
	 */
	@Select("select * from department where depart_id = #{departId}")
	Department getDepartmentById(int departId);
	
	/**
	 * 根据部门名称查询部门
	 */
	@Select("select * from department where depart_name = #{departName}")
	Department getDepartmentByName(String departName);
	
	/**
	 * 插入部门
	 */
	@Insert("insert into department(depart_name,depart_desc) values(#{departName},#{departDesc})")
	void insertDepartment(Department department);
	
	/**
	 * 更新部门
	 */
	@Update("update department set depart_name=#{departName}, depart_desc=#{departDesc} "
			+ "where depart_id=#{departId}")
	void updateDepartment(Department department);
	
	/**
	 * 删除部门
	 */
	@Delete("delete from department where depart_id=#{departId}")
	void deleteDepartment(int departId);
	
	/**
	 * 获取职位列表
	 */
	@Select("select *, d.depart_name as departName "
			+ "from position p left join department d on p.depart_id = d.depart_id ")
	List<Position> getPositions();
	
	/**
	 * 根据部门id获取职位列表
	 */
	@Select("select *, d.depart_name as departName "
			+ "from position p left join department d on p.depart_id = d.depart_id "
			+ "where p.depart_id = #{departId}")
	List<Position> getPositionsByDepartId(int departId);
	
	/**
	 * 根据职位id查询职位
	 */
	@Select("select *, d.depart_name as departName "
			+ "from position p left join department d on p.depart_id = d.depart_id "
			+ "where p.position_id=#{positionId}")
	Position getPositionById(int positionId);
	
	/**
	 * 根据职位名称查询职位
	 */
	@Select("select *, d.depart_name as departName "
			+ "from position p left join department d on p.depart_id = d.depart_id "
			+ "where p.position_name=#{positionName}")
	Position getPositionByName(String positionName);
	
	/**
	 * 插入职位
	 */
	@Insert("insert into position (position_name, position_description, depart_id) "
			+ "values (#{positionName},#{positionDescription},#{departId})")
	void insertPosition(Position position);
	
	/**
	 * 更新职位
	 */
	@Update("update position set position_name=#{positionName}, "
			+ "position_description=#{positionDescription}, depart_id=#{departId} "
			+ "where position_id=#{positionId}")
	void updatePosition(Position position);
	
	/**
	 * 删除职位
	 */
	@Delete("delete from position where position_id=#{positionId}")
	void deletePosition(int positionId);
	
	/**
	 * 查询部门列表，封装为组织结构树
	 */
	@Select("select depart_name as id, depart_name as name from department")
	List<ZtreeModel> getOrgTree();
}
