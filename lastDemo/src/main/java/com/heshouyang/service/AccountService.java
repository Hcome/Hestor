package com.heshouyang.service;

import com.github.pagehelper.PageInfo;
import com.heshouyang.entity.Account;

public interface AccountService {

	Integer accountAllIsUseByMakectName(String makectName);
	
	PageInfo<Account> quertAccount(Integer pageNum);
}
