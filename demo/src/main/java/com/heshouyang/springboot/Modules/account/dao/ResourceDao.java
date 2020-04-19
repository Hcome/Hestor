package com.heshouyang.springboot.Modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.heshouyang.springboot.Modules.account.entity.Resource;

@Repository
@Mapper
public interface ResourceDao {

	@Insert("insert m_resource(resource_name, resource_uri, permission) value(#{resourceName}, "
			+ "#{resourceUri}, #{permission})")
	@Options(useGeneratedKeys = true, keyProperty = "resourceId", keyColumn = "resource_id")
	void addResource(Resource resource);
	
	@Update("update m_resource set resource_name = #{resourceName}, resource_uri = #{resourceUri}, "
			+ "permission=#{permission} where resource_id=#{resourceId}")
	void updateResource(Resource resource);
	
	@Delete("delete from m_resource where resource_id = #{resourceId}")
	void deleteResource(int resourceId);
	
	@Select("select * from m_resource")
	List<Resource> getResources();
	
	@Select("select * from m_resource resource left join m_role_resource roleResource on "
			+ "resource.resource_id = roleResource.resource_id where roleResource.role_id = #{roleId}")
	List<Resource> getResourcesByRoleId(int roleId);
	
	@Select("select * from m_resource where resource_id=#{resourceId}")
	@Results(id="resourceResult", value={
			@Result(column="resource_id", property="resourceId"),
			@Result(column="resource_id",property="roles",
					javaType=List.class,
					many=@Many(select="com.heshouyang.springboot.Modules"
							+ ".account.dao.RoleDao.getRolesByResourceId"))
		})
	Resource getResourceById(int resourceId);
}
