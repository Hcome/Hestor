package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.Admin;

public interface AdminMapper {
	/**
	 * 新增管理员
	 * @param admin
	 * @return
	 */
	int insertAdmin(Admin admin);
	/**
	 * 查询管理员
	 */
	List<Admin> queryAdminAll();
}
