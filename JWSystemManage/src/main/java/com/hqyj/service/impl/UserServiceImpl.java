package com.hqyj.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.RoleMapper;
import com.hqyj.dao.UserMapper;
import com.hqyj.entity.User;
import com.hqyj.model.vo.Result;
import com.hqyj.model.vo.UserAndRole;
import com.hqyj.service.UserService;
import com.hqyj.util.MD5Util;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper um;
	@Autowired
	private RoleMapper rm;

	@Override
	public User selectUserByUserByName(String userName) {
		User user = um.selectUserByUserName(userName);
		return user;
	}

	@Override
	public Result login(User user) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPassword());
		try {
			subject.login(token);
			User u = (User) SecurityUtils.getSubject().getSession().getAttribute("u");
			if (u == null) {
				return new Result("500", "账号不存在！");
			}
			subject.checkRoles();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new Result("500", "账号密码错误！");
		}
		return new Result("200", "success");
	}

	@Override
	public Result registerUser(User user) {
		// 判断该用户名是否已经存在
		User u = um.selectByPrimaryKey1(user.getUserName());
		if (u != null) {
			return new Result("400", "该用户名已存在！");
		} else {
			// 对密码加密
			String userPassword = new MD5Util().getPasswordByMD5(user.getUserPassword(), user.getUserName());
			user.setUserPassword(userPassword);
			int num = um.adduser(user);
			if (num > 0) {
				System.out.println(user.getUserId() + "@@@@@@@@@@@@@@@@");
				UserAndRole ur = new UserAndRole();
				ur.setUserId(user.getUserId());
				ur.setRoleId(4);
				int num1 = um.insertUserAndRole(ur);
				if (num1 > 0) {
					return new Result("200", "success");
				} else {
					return new Result("500", "角色初始化失败！");
				}

			} else {
				return new Result("500", "注册失败！");
			}
		}
	}

	@Override
	public User selectUserByUserByName1(String userName) {

		return um.selectByPrimaryKey1(userName);
	}

	@Override
	public PageInfo<User> selectUserAll(int pageNum) {
		System.out.println(pageNum);
		PageHelper ph = new PageHelper();
		ph.startPage(pageNum, 3);
		List<User> users = um.queryUserAll();

		PageInfo<User> info = new PageInfo<>(users);

		System.out.println(info + "-------------");
		return info;
	}

	@Override
	public Result deleteUserById(int userId) {
		int num = um.deleteByPrimaryKey(userId);
		int num1 = um.deleteUserAndRole(userId);
		if (num > 0 && num1 > 0) {
			return new Result("200", "success");
		} else {
			return new Result("500", "删除失败");
		}
	}

	@Override
	public User selectUserById(int userId) {

		return um.selectUserByUserId(userId);
	}

	@Override
	public int updateUser(User user) {
		System.out.println("+++++++++++++"+user.getUserId());
		int num = um.updateByPrimaryKeySelective(user);
		return num;
	}

	@Override
	public int deleteUserAndRole(int userId) {

		return um.deleteUserAndRole(userId);
	}

	@Override
	public int insertUserAndRole(UserAndRole userAndRole) {
		
		return um.insertUserAndRole(userAndRole);
	}

	@Override
	public User selectUserIsAdminAllInfo(String userName) {
		User user = um.queryUserIsAdminAllInfo(userName);
		return user;
	}

	@Override
	public User selectUserIsTeacherAllInfo(String userName) {
		User user = um.queryUserIsTeacherAllInfo(userName);
		return user;
	}

	@Override
	public User selectUserIsStudentAllInfo(String userName) {
		User user = um.queryUserIsStudentAllInfo(userName);
		return user;
	}

	@Override
	public PageInfo<User> selectUsersAndRoles(int pageNum) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum,3);
		List<User> list = um.queryUsersAndRoles();
		PageInfo<User> userInfo = new PageInfo<User>(list);
		return userInfo;
	}

	@Override
	public List<UserAndRole> selectUserAndRole() {
		List<UserAndRole> list = um.queryRole();
		return list;
	}

}
