package com.heshouyang.springboot.Modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.heshouyang.springboot.Modules.account.entity.Role;

@Repository
@Mapper
public interface UserRoleDao {

	@Delete("delete from m_user_role where user_id = #{userId}")
	void deletUserRoleByUserId(int userId);
	
	@Insert("insert m_user_role(role_id, user_id) value(#{roleId}, #{userId})")
	void addUserRole(@Param("roleId") int roleId, @Param("userId") int userId);
	
	@Select("select * from m_role role left join m_user_role userRole "
			+ "on role.role_id = userRole.role_id where userRole.user_id = #{userId}")
	List<Role> getRolesByUserId(int userId);
}
