package com.hqyj.erp.modules.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.dao.AccountDao;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.authority.dao.AuthorityDao;
import com.hqyj.erp.modules.authority.entity.UserRole;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.util.MD5Util;

@Service
public class AccountServiceImpl implements AccountService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private AuthorityDao authorityDao;

	/* 
	 * 新增或更新user信息，删除已有的用户角色信息，插入新的用户角色
	 */
	@Override
	public Result inserOrUpdatetUser(User user) {
		if (user == null || StringUtils.isBlank(user.getAccount()) 
				|| (StringUtils.isBlank(user.getPassword()) && user.getUserId() <= 0)) {
			return new Result(500, "User name or password is null.");
		}
		
		User existUser = accountDao.getUserByName(user.getAccount());
		if (existUser != null && 
				((existUser.getUserId() != user.getUserId()) || user.getUserId() <= 0)) {
			return new Result(500, "User is exist.");
		}
		
		try {
			user.initUserPassword();
			if (user.getUserId() > 0) {
				accountDao.updateUserById(user);
			} else {
				accountDao.insertUser(user);
			}
			
			authorityDao.deleteUserRole(user.getUserId());
			Integer[] userRoles = user.getUserRoles();
			if (userRoles != null) {
				for (Integer roleId : userRoles) {
					authorityDao.insertUserRole(new UserRole(user.getUserId(), roleId));
				}
			}
			
			return new Result(200, "insert User success.", user);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
			return new Result(500, "insert User fail.");
		}
	}

	/* 
	 * 用户登录获取用户信息，添加shiro用户验证、用户授权以及记住我功能点
	 */
	@Override
	public Result getUserResult(User user) {
		Subject subject = SecurityUtils.getSubject();
		try {
			LOGGER.debug(user.getPassword());
			UsernamePasswordToken usernamePasswordToken = 
					new UsernamePasswordToken(user.getAccount(), MD5Util.getMD5(user.getPassword()));
			usernamePasswordToken.setRememberMe(user.getRememberMe());
			
			// 登录验证，调用MyRealm中doGetAuthenticationInfo方法
			subject.login(usernamePasswordToken);
			
			// 授权，调用MyRealm中doGetAuthorizationInfo方法
			subject.checkRoles();
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, e.getMessage());
		}
		
		return new Result(200, "success");
	}

	/* 
	 * 从shiro中获取user
	 */
	@Override
	public User getUserBySubject() {
		Subject subject = SecurityUtils.getSubject();
		return getUserByName((String)subject.getPrincipal());
	}

	/* 
	 * 根据用户名查询user
	 */
	@Override
	public User getUserByName(String account) {
		return accountDao.getUserByName(account);
	}

	/* 
	 * 根据user id查询user
	 */
	@Override
	public User getUserById(int userId) {
		return accountDao.getUserById(userId);
	}

	/* 
	 * 根据页面查询条件获取user 列表，封装到pageInfo对象中
	 */
	@Override
	public PageInfo<User> getUserList(SearchVo userSearch) {
		Subject subject = SecurityUtils.getSubject();
		String currentRole = (String) subject.getPrincipal();
		
		List<User> users = new ArrayList<>();
		SearchVo.initSearchVo(userSearch);
		PageHelper.startPage(userSearch.getCurrentPage(), userSearch.getPageSize());
		try {
			if ("staff".equals(currentRole)) {
				users.add(accountDao.getUserById(getUserBySubject().getUserId()));
			} else {
				users = accountDao.getUserListBySearch(userSearch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new PageInfo<>(users);
	}

	/* 
	 * 根据user id 删除用户
	 */
	@Override
	public Result deleteUserById(int userId) {
		try {
			accountDao.deleteUserById(userId);
			return new Result(200, "删除成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "删除失败。");
		}
	}

	/* 
	 * 根据当前用户id查询上级user信息
	 */
	@Override
	public List<User> getLeadersByCurrentUserId(int userId) {
		return accountDao.getLeadersByCurrentUserId(userId);
	}
}
