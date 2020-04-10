package com.hqyj.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Admin;
import com.hqyj.model.vo.Result;

public interface AdminService {
	/**
	 * 新增管理员功能
	 * @param admin
	 * @return
	 */
	int insertAdmin(Admin admin);
	/**
	 * 查询所有的管理员
	 * @param pageNum
	 * @return
	 */
	PageInfo<Admin> selectAdminAll(int pageNum);
	
	Admin queryAdminById(Integer id);
	
	int updateAdmin(Admin admin);
	
	Result deleteAdminById(Integer id);

}
