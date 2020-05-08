package com.hqyj.erp.modules.organization.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.organization.entity.Department;
import com.hqyj.erp.modules.organization.entity.Position;
import com.hqyj.erp.modules.organization.vo.ZtreeModel;

/**
 * Organization Service
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public interface OrganizationService {

	List<Department> getDepartments();
	
	Department getDepartmentById(int departId);
	
	Department getDepartmentByName(String departName);
	
	Result insertOrUpdateDepartment(Department department);
	
	Result deleteDepartment(int departId);
	
	List<Position> getPositions();
	
	Position getPositionById(int positionId);
	
	Result insertOrUpdatePosition(Position position);
	
	PageInfo<Position> getPositionsByPage(SearchVo searchVo);
	
	Result deletePosition(int positionId);
	
	List<Position> getPositionsByDepartId(int departId);
	
	List<ZtreeModel> getOrgTree();
}
