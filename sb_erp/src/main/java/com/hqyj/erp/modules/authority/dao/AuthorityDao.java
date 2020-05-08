package com.hqyj.erp.modules.authority.dao;

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
import org.springframework.stereotype.Repository;

import com.hqyj.erp.modules.authority.entity.Resource;
import com.hqyj.erp.modules.authority.entity.Role;
import com.hqyj.erp.modules.authority.entity.RoleResource;
import com.hqyj.erp.modules.authority.entity.UserRole;

/**
 * 权限相关dao
 * @author: HymanHu
 * @date: 2019年11月11日
 */
@Repository
@Mapper
public interface AuthorityDao {

	/**
	 * 查询所有角色
	 */
	@Select("select * from role")
	List<Role> getRoles();
	
	/**
	 * 根据id查询角色
	 */
	@Select("select * from role where role_id=#{roleId}")
	Role getRoleById(int roleId);
	
	/**
	 * 根据name查询角色
	 */
	@Select("select * from role where role_name=#{roleName}")
	Role getRoleByNmae(String roleName);
	
	/**
	 * 插入角色
	 */
	@Insert("insert into role(role_name, role_desc) values(#{roleName}, #{roleDesc})")
	void insertRole(Role role);
	
	/**
	 * 更新角色
	 */
	@Update("update role set role_name=#{roleName}, role_desc=#{roleDesc} where role_id=#{roleId}")
	void updateRole(Role role);
	
	/**
	 * 删除角色
	 */
	@Delete("delete from role where role_id=#{roleId}")
	void deleteRole(int roleId);
	
	/**
	 * 根据资源id查询角色列表
	 */
	@Select("select * from role r "
			+ "left join role_resource rr on r.role_id = rr.role_id "
			+ "where rr.resource_id = #{resourceId}")
	List<Role> getRolesByResourceId(int resourceId);
	
	/**
	 * 根据用户id查询角色列表
	 */
	@Select("select * from role r "
			+ "left join user_role ur on r.role_id = ur.role_id "
			+ "where ur.user_id = #{userId}")
	List<Role> getRolesByUserId(int userId);
	
	/**
	 * 查询所有资源
	 */
	@Select("select * from resource")
	List<Resource> getResources();
	
	/**
	 * 根据角色id查询所有资源
	 */
	@Select("select * from resource r "
			+ "left join role_resource rr on r.resource_id = rr.resource_id "
			+ "where rr.role_id = #{roleId}")
	List<Resource> getResourcesByRoleId(int roleId);
	
	/**
	 * 根据资源id查询资源
	 */
	@Select("select * from resource where resource_id=#{resourceId}")
	@Results(id="resourceResult", value={
		@Result(column="resource_id", property="resourceId"),
		@Result(column="resource_id",property="roles",
				javaType=List.class,
				many=@Many(select="com.hqyj.erp.modules.authority.dao.AuthorityDao.getRolesByResourceId"))
	})
	Resource getResourceById(int resourceId);
	
	/**
	 * 根据资源name查询资源
	 */
	@Select("select * from resource where resource_name=#{resource_name}")
	@ResultMap(value="resourceResult")
	Resource getResourceByName(String resourceName);
	
	/**
	 * 插入资源
	 */
	@Insert("insert into resource (resource_name, resource_url, resource_description) "
			+ "values (#{resourceName}, #{resourceUrl}, #{resourceDescription})")
	@Options(useGeneratedKeys=true, keyColumn="resource_id", keyProperty="resourceId")
	void insertResource(Resource resource);
	
	/**
	 * 更新资源
	 */
	@Update("update resource set resource_name=#{resourceName}, "
			+ "resource_url=#{resourceUrl}, resource_description=#{resourceDescription} "
			+ "where resource_id=#{resourceId}")
	void updateResource(Resource resource);
	
	/**
	 * 删除资源
	 */
	@Delete("delete from resource where resource_id=#{resource_id}")
	void deleteResource(int resourceId);
	
	/**
	 * 删除角色资源
	 */
	@Delete("delete from role_resource where resource_id=#{resourceId}")
	void deleteRoleResource(int resourceId);
	
	/**
	 * 插入角色资源
	 */
	@Insert("insert into role_resource(role_id, resource_id) values(#{roleId}, #{resourceId})")
	void insertRoleResource(RoleResource roleResource);
	
	/**
	 * 删除用户角色
	 */
	@Delete("delete from user_role where user_id=#{userId}")
	void deleteUserRole(int userId);
	
	/**
	 * 插入用户角色
	 */
	@Insert("insert into user_role(role_id, user_id) values(#{roleId}, #{userId})")
	void insertUserRole(UserRole userRole);
}
