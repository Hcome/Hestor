package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.User;
import com.hqyj.model.vo.UserAndRole;

public interface UserMapper {
	int deleteByPrimaryKey(Integer userId);

	int deleteUserAndRole(int userId);

	User selectByPrimaryKey(Integer userId);

	/**
	 * 只查询用户的信息
	 * 
	 * @param userName
	 * @return
	 */
	User selectByPrimaryKey1(String userName);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/**
	 * 查询用户的信息（包括角色和权限）
	 * 
	 * @param userName
	 * @return
	 */
	User selectUserByUserName(String userName);

	User selectUserByUserId(int userId);

	int adduser(User user);

	List<User> queryUserAll();

	List<UserAndRole> queryUserAndRoleByUserId(Integer userId);

	int insertUserAndRole(UserAndRole userAndRole);
	/**
	 * 根据用户名去查询当前用户的角色
	 * @param userName
	 * @return
	 */
	User selectUserRoles(String userName);
	/**
	 * 查询用户是管理员的全部信息，包括用户信息，角色信息，管理员信息
	 * @param userName
	 * @return
	 */
	User queryUserIsAdminAllInfo(String userName);
	/**
	 * 查询用户是老师的全部信息，包括用户信息，角色信息，管理员信息
	 * @param userName
	 * @return
	 */
	User queryUserIsTeacherAllInfo(String userName);
	/**
	 * 查询用户是学生的全部信息，包括用户信息，角色信息，管理员信息
	 * @param userName
	 * @return
	 */
	User queryUserIsStudentAllInfo(String userName);



}