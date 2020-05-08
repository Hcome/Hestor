package com.heshouyang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heshouyang.dao.AccountMapper;
import com.heshouyang.entity.Account;
import com.heshouyang.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountMapper am;
	public Integer accountAllIsUseByMakectName(String makectName) {
		
		return am.accountAllIsUseByMakectName(makectName);
	}
	@SuppressWarnings("static-access")
	@Override
	public PageInfo<Account> quertAccount(Integer pageNum) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum, 3);
		List<Account> list = am.queryAccounts();
		PageInfo<Account> info = new PageInfo<>(list);
		return info;
	}
}
