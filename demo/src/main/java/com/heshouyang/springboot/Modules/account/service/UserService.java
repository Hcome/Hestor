package com.heshouyang.springboot.Modules.account.service;

import com.github.pagehelper.PageInfo;
import com.heshouyang.springboot.Modules.account.entity.User;
import com.heshouyang.springboot.Modules.common.vo.Result;
import com.heshouyang.springboot.Modules.common.vo.SearchVo;


public interface UserService {
	
	Result insertUser(User user);
	
	User getUserByUserName(String userName);
	
	Result login(User user);
	
	void logout();
	
	PageInfo<User> getUsersBySearchVo(SearchVo searchVo);
	
	User getUserById(int userId);
	
	Result updateUser(User user);
	
	Result deleteUser(int userId);
}
