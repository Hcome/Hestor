package com.hqyj.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.User;
import com.hqyj.model.vo.Result;
import com.hqyj.model.vo.UserAndRole;

public interface UserService {
	// 联表查询
	User selectUserByUserByName(String userName);

	// 查询单表t_user
	User selectUserByUserByName1(String userName);
	//查询用户是管理员的全部信息
	User selectUserIsAdminAllInfo(String userName);
	//查询用户是管理员的全部信息
	User selectUserIsTeacherAllInfo(String userName);
	//查询用户是管理员的全部信息
	User selectUserIsStudentAllInfo(String userName);
	//用户登录功能
	Result login(User user);
	//用户注册功能
	Result registerUser(User user);
	//查询所有的用户
	PageInfo<User> selectUserAll(int pageNum);
	//通过用户的id去删除用户
	Result deleteUserById(int userId);
	//通过用户的id去查询用户信息
	User selectUserById(int userId);
	//修改用户信息
	int updateUser(User user);
	//通过用户的id去删除用户对应的角色信息
	int deleteUserAndRole(int userId);
	//新增用户对应的角色信息
	int insertUserAndRole(UserAndRole userAndRole);
}
