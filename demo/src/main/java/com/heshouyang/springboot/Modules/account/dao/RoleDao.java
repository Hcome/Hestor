package com.heshouyang.springboot.Modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.heshouyang.springboot.Modules.account.entity.Role;

@Repository
@Mapper
public interface RoleDao {

	@Insert("insert m_role(role_name) value(#{roleName})")
	@Options(useGeneratedKeys=true, keyProperty="roleId", keyColumn="role_id")
	void addRole(Role role);
	
	@Update("update m_role set role_name = #{roleName} where role_id = #{roleId}")
	void updateRole(Role role);
	
	@Delete("delete from m_role where role_id = #{roleId}")
	void deleteRole(int roleId);
	
	@Select("select * from m_role")
	List<Role> getRoles();
	
	@Select("select * from m_role role left join m_user_role userRole "
			+ "on role.role_id = userRole.role_id where userRole.user_id = #{userId}")
	List<Role> getRolesByUserId(int userId);
	
	@Select("select * from m_role role left join m_role_resource roleResource "
			+ "on role.role_id = roleResource.role_id where roleResource.resource_id = #{resourceId}")
	List<Role> getRolesByResourceId(int resourceId);
	
	@Select("select * from m_role where role_id=#{roleId}")
	Role getRoleById(int roleId);
}
