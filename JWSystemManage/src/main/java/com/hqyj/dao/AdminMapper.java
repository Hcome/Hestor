package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.Admin;
import com.hqyj.model.vo.Result;

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
	/**
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	int updateAdmin(Admin admin);
	/**
	 * 根据管理员id查询
	 * @param id
	 * @return
	 */
	Admin queryAdminById(Integer id);
	/**
	 * 删除管理员
	 * @param id
	 * @return
	 */
	int deleteAdminById(Integer id);
	
}
