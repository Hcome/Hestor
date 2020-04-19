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
	/**
	 * 根据用户的id去查询用户
	 * @param userId
	 * @return
	 */
	User selectUserByUserId(int userId);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int adduser(User user);
	/**
	 * 查询所用的用户
	 * @return
	 */
	List<User> queryUserAll();
	/**
	 * 通过用户的id去查询用户所对应的角色
	 * @param userId
	 * @return
	 */
	List<UserAndRole> queryUserAndRoleByUserId(Integer userId);
	/**
	 * 如果新增用户，可以增加对应角色信息
	 * @param userAndRole
	 * @return
	 */
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
	/**
	 * 查询第三方表的所有角色对应的信息
	 * @return
	 */
	List<UserAndRole> queryRole();
}