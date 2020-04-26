package com.heshouyang.dao;

import com.heshouyang.entity.User;

public interface UserMapper {

	User selectUserById(Integer id);

	User selectUserByUserName(String userName);
	
}
