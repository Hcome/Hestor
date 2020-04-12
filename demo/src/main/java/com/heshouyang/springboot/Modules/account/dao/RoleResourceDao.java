package com.heshouyang.springboot.Modules.account.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleResourceDao {

	@Delete("delete from m_role_resource where resource_id = #{resourceId}")
	void deletRoleResourceByResourceId(int resourceId);
	
	@Insert("insert m_role_resource(role_id, resource_id) value(#{roleId}, #{resourceId})")
	void addRoleResource(@Param("roleId") int roleId, @Param("resourceId") int resourceId);
	
}
