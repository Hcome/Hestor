package com.heshouyang.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.heshouyang.dao.RoleMapper;
import com.heshouyang.dao.UserMapper;
import com.heshouyang.entity.Role;
import com.heshouyang.entity.User;

public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	private UserMapper um;
	@Autowired
	private RoleMapper rm;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// shiro的回调函数，每一步操作都会去执行,这个方法执行的流程是当前一个用户执行登录验证之后
		//如果用户的某个模块需要某个权限的时候他就会根据权限的name属性去查询这个用户所对应的角色名称
		//有多少个角色模块他就会执行多少次，
		System.out.println("+++++++++++++++");
		Set<String> sets = new HashSet<>();
		List<Role> list = rm.selectRoles((String)(principals.getPrimaryPrincipal()));
		for (Role role : list) {
			sets.add(role.getRoleName());
		}
		return new SimpleAuthorizationInfo(sets);
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//通过这个令牌对象获取当前登录的用户名
		String userName = (String) token.getPrincipal();
		//通过用户名去查询数据库中是否有此用户，
		User user = um.selectUserByUserName(userName);
		if (user != null) {
			
			String passWord = user.getPassWord();
			ByteSource salt = ByteSource.Util.bytes(user.getUserName());
			// 获取当前对象的名字
			String name = this.getName();
			return new SimpleAuthenticationInfo(userName, passWord, salt, name);
		}else {
			return (AuthenticationInfo) new AuthenticationException();
		}
	}
}
