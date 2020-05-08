package com.hqyj.erp.modules.account.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;

/**
 * account service
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public interface AccountService {

	Result inserOrUpdatetUser(User user);
	
	Result getUserResult(User user);
	
	User getUserBySubject();
	
	User getUserByName(String account);
	
	User getUserById(int userId);
	
	PageInfo<User> getUserList(SearchVo userSearch);
	
	Result deleteUserById(int userId);
	
	List<User> getLeadersByCurrentUserId(int userId);
}
