package com.heshouyang.dao;

import java.util.List;

import com.heshouyang.entity.Account;
/**
 * 公司的资产管理中心，包括资产的入账和出账
 * @author Administrator
 *
 */
public interface AccountMapper {
	/**
	 * 增加商场账户流动记录
	 * @return
	 */
	int addAccountReCoding(Account account);
	/**
	 * 通过商场的名称去查询账户的可用信息
	 * @param makectName
	 * @return
	 */
	Integer accountAllIsUseByMakectName(String makectName);
	/**
	 * 查询所有的流动记录
	 * @return
	 */
	List<Account> queryAccounts();
	
    int deleteByPrimaryKey(Integer accountId);

    Account selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}