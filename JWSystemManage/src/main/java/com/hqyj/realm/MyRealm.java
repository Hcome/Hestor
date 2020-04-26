package com.hqyj.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.hqyj.entity.Role;
import com.hqyj.entity.User;
import com.hqyj.service.RoleService;
import com.hqyj.service.UserService;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserService us;
	@Autowired
	private RoleService rs;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 将该用户所拥有的角色名添加到set
		Set<String> roleNames = new HashSet<>();
		// 获取userName(页面输入的)
		String userName = (String) arg0.getPrimaryPrincipal();
		// 从数据库查询用户信息(级联操作，查出用户所拥有的角色和权限)
		User user = us.selectUserByUserByName(userName);
		// user为空代表还没分配角色
		if (user == null) {
			roleNames.add("");
		} else {
			// 查询出该用户所拥有的角色
			List<Role> roles = user.getRoles();
			for (Role role : roles) {
				roleNames.add(role.getRoleName());
				/*
				 * // 通过roleId查询出role所拥有的权限 List<Menu> menus =
				 * rs.selectRoleById(role.getRoleId()).getMenus(); //
				 * 将menuLinkt添加到simpleAuthorizationInfo for (Menu menu : menus)
				 * {
				 * simpleAuthorizationInfo.addStringPermission(menu.getMenuLink(
				 * )); }
				 */
			}

			// 将该用户所拥有的角色名添加到simpleAuthorizationInfo
			simpleAuthorizationInfo.addRoles(roleNames);
		}

		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// 获取当前登录人的用户名(token是登录凭证)

		String userName = (String) arg0.getPrincipal();
		System.out.println(userName + "%%%%%%%%%%%%%%%%%%%%%%%%%%");
		// 从数据库中去查询该用户名对应的用户信息
		// 从数据库查询出用户（操作单表t_user）
		User user = us.selectUserByUserByName1(userName);
		System.out.println(user + "^^^^^^^^^^^^^^^^");
		SecurityUtils.getSubject().getSession().setAttribute("u", user);
		// 该用户不存在
		if (user == null) {
			return null;
		}
		// 获取盐
		ByteSource salt = ByteSource.Util.bytes(userName);
		// 返回认证信息由父类AuthenticatingRealm进行认证
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName,
				user.getUserPassword(), salt, getName());
		return simpleAuthenticationInfo;
	}

}
