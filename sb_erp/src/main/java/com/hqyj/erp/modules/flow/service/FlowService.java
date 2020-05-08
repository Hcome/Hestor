package com.hqyj.erp.modules.flow.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.flow.entity.Apply;

/**
 * Flow Service
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public interface FlowService {

	Result insertOrUpdateApply(Apply apply);
	
	PageInfo<Apply> getApplies(SearchVo searchVo);
	
	PageInfo<Apply> applyFlows(SearchVo searchVo);
	
	Apply getApplyById(int applyId);
	
	Result deleteApply(int applyId);
	
	Result updateApplyFlow(Apply apply);
}
