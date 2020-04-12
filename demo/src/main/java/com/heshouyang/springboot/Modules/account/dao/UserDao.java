package com.heshouyang.springboot.Modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.heshouyang.springboot.Modules.account.entity.User;
import com.heshouyang.springboot.Modules.common.vo.SearchVo;



@Repository
@Mapper
public interface UserDao {

	@Insert("insert into m_user (user_name, password, create_date) "
			+ "values (#{userName}, #{password}, #{createDate})")
	@Options(useGeneratedKeys=true, keyColumn="user_id", keyProperty="userId")
	void insertUser(User user);
	
	@Select("select * from m_user where user_name = #{userName}")
	User getUserByUserName(String userName);
	
	@Select("select * from m_user where user_name=#{userName} and password=#{password}")
	User getUser(User user);
	
	@Select("<script>" + 
			"select * from m_user "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ "and user_name like '%${keyWord}%' "
			+ "</if>"
			+ "</where>"
			+ "<choose>"
			+ "<when test='orderBy != \"\" and orderBy != null'>"
			+ "order by ${orderBy} ${sort}"
			+ "</when>"
			+ "<otherwise>"
			+ "order by create_date desc"
			+ "</otherwise>"
			+ "</choose>"
			+ "</script>")
	List<User> getUsersBySearchVo(SearchVo searchVo);
	
	@Select("select * from m_user where user_id=#{userId}")
	@Results(id="userResult", value={
			@Result(column="user_id", property="userId"),
			@Result(column="user_id",property="roles",
					javaType=List.class,
					many=@Many(select="com.thornBird.springBootDemo.modules.account.dao."
							+ "UserRoleDao.getRolesByUserId"))
		})
	User getUserById(int userId);
	
	@Update("update m_user set user_name=#{userName} where user_id=#{userId}")
	void updateUser(User user);
	
	@Select("delete from m_user where user_id=#{userId}")
	void deleteUser(int userId);
}
