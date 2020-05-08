package com.hqyj.erp.modules.flow.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.erp.exception.ErpException;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.flow.dao.FlowDao;
import com.hqyj.erp.modules.flow.entity.Apply;
import com.hqyj.erp.modules.flow.service.FlowService;
import com.hqyj.erp.modules.property.constant.ApplyStatus;
import com.hqyj.erp.modules.property.constant.ApplyType;
import com.hqyj.erp.modules.property.dao.PropertyDao;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;
import com.hqyj.erp.modules.property.entity.ScrapProperty;

/**
 * Flow Service Impl
 * @author: HymanHu
 * @date: 2019年11月11日
 */
@Service
public class FlowServiceImpl implements FlowService {
	
	@Autowired
	private FlowDao flowDao;
	@Autowired
	private AccountService accountService;
	@Autowired
	private PropertyDao propertyDao;

	/* 
	 * 插入和更新申请
	 */
	@Override
	public Result insertOrUpdateApply(Apply apply) {
		try {
			User user = accountService.getUserById(apply.getApplyUserId());
			apply.setApplyDate(new Date());
			apply.setApplyUserName(user.getUserName());
			apply.setApplyStatus(ApplyStatus.APPLY.getDesc());
			
			if (apply.getApplyId() > 0) {
				Apply existApply = flowDao.getApplyById(apply.getApplyId());
				existApply.setApplyType(apply.getApplyType());
				existApply.setPropertyModel(apply.getPropertyModel());
				existApply.setPropertyName(apply.getPropertyName());
				existApply.setPropertyNum(apply.getPropertyNum());
				existApply.setPropertyType(apply.getPropertyType());
				existApply.setUnitPrice(apply.getUnitPrice() == null ? 0.0 : apply.getUnitPrice());
				existApply.setTotalPrice(apply.getUnitPrice() * apply.getPropertyNum());
				flowDao.updateApply(existApply);
			} else {
				apply.setUnitPrice(apply.getUnitPrice() == null ? 0.0 : apply.getUnitPrice());
				apply.setTotalPrice(apply.getUnitPrice() * apply.getPropertyNum());
				flowDao.insertApply(apply);
			}
			
			return new Result(200, "Apply success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Apply failed.");
		}
	}

	/* 
	 * 获取申请列表，封装到page info中
	 */
	@Override
	public PageInfo<Apply> getApplies(SearchVo searchVo) {
		try {
			SearchVo.initSearchVo(searchVo);
			PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
			
			List<Apply> applies = 
					Optional.ofNullable(flowDao.getApplies(searchVo))
					.orElse(Collections.emptyList());
			return new PageInfo<>(applies);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new PageInfo<>();
	}

	/* 
	 * 获取申请流程列表，封装到pageinfo中
	 */
	@Override
	public PageInfo<Apply> applyFlows(SearchVo searchVo) {
		try {
			SearchVo.initSearchVo(searchVo);
			PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
			
			List<Apply> applies = 
					Optional.ofNullable(flowDao.applyFlows(searchVo))
					.orElse(Collections.emptyList());
			return new PageInfo<>(applies);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new PageInfo<>();
	}

	/* 
	 * 根据id查询申请
	 */
	@Override
	public Apply getApplyById(int applyId) {
		return flowDao.getApplyById(applyId);
	}

	/* 
	 * 删除申请
	 */
	@Override
	public Result deleteApply(int applyId) {
		try {
			flowDao.deleteApply(applyId);
			return new Result(200, "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "操作失败");
		}
	}

	/* 
	 * 更新申请流程，根据申请提交状态，更新资产表、在用资产表、报废资产表
	 */
	@Override
	@Transactional
	public Result updateApplyFlow(Apply apply) {
		Apply existApply = flowDao.getApplyById(apply.getApplyId());
		User user = accountService.getUserById(apply.getApproveUserId());
		existApply.setApproveUserId(user.getUserId());
		existApply.setApproveDate(new Date());
		existApply.setApplyStatus(apply.getApplyStatus());
		existApply.setApproveDesc(apply.getApproveDesc());
		
		flowDao.updateApply(existApply);
		updateProperyByFlow(existApply);
		updateGrantPropertyByFlow(existApply);
		updateScrapPropertyByFlow(existApply);
		
		return new Result(200, "操作成功。");
	}
	
	/**
	 * 更新资产表
	 */
	public void updateProperyByFlow(Apply apply) {
		if (apply.getApplyStatus().equals(ApplyStatus.APPROVE.getDesc())) {
			Property property = Property.initProperty(apply);
			if (apply.getApplyType().equals(ApplyType.GRANT.getDesc())) {
				Property existProperty = propertyDao.getPropertyByAttribute(property);
				if (existProperty == null || existProperty.getPropertyNum() < apply.getPropertyNum()) {
					throw new ErpException(500, "库存数量不足。");
				} else {
					existProperty.setPropertyNum(
							existProperty.getPropertyNum() - apply.getPropertyNum());
					existProperty.setUnitPrice(apply.getUnitPrice());
					existProperty.setTotalPrice(
							existProperty.getUnitPrice() * existProperty.getPropertyNum());
					propertyDao.updateProperty(existProperty);
				}
			} else if (apply.getApplyType().equals(ApplyType.PURCHASE.getDesc())) {
				Property existProperty = propertyDao.getPropertyByAttribute(property);
				if (existProperty == null) {
					propertyDao.insertProperty(property);
				} else {
					existProperty.setPropertyNum(
							existProperty.getPropertyNum() + apply.getPropertyNum());
					existProperty.setUnitPrice(apply.getUnitPrice());
					existProperty.setTotalPrice(
							existProperty.getUnitPrice() * existProperty.getPropertyNum());
					propertyDao.updateProperty(existProperty);
				}
			}
		}
	}
	
	/**
	 * 更新在用资产表
	 */
	public void updateGrantPropertyByFlow(Apply apply) {
		GrantProperty grantProperty = GrantProperty.init(apply);
		GrantProperty existGrantProperty = 
				propertyDao.getGrantPropertyByAttribute(grantProperty);
		if (apply.getApplyStatus().equals(ApplyStatus.APPROVE.getDesc())) {
			if (apply.getApplyType().equals(ApplyType.GRANT.getDesc())) {
				if (existGrantProperty == null) {
					grantProperty.setUserId(apply.getApplyUserId());
					propertyDao.insertGrantProperty(grantProperty);
				} else {
					existGrantProperty.setPropertyNum(
							existGrantProperty.getPropertyNum() + apply.getPropertyNum());
					existGrantProperty.setUnitPrice(apply.getUnitPrice());
					existGrantProperty.setTotalPrice(
							existGrantProperty.getPropertyNum() * existGrantProperty.getUnitPrice());
					propertyDao.updateGrantProperty(existGrantProperty);
				}
			} else if (apply.getApplyType().equals(ApplyType.SCRAP.getDesc())) {
				if (existGrantProperty == null || 
						(existGrantProperty.getPropertyNum() < apply.getPropertyNum())) {
					throw new ErpException(500, "该用户在用数量不足。");
				} else {
					existGrantProperty.setPropertyNum(
							existGrantProperty.getPropertyNum() - apply.getPropertyNum());
					existGrantProperty.setTotalPrice(
							existGrantProperty.getPropertyNum() * existGrantProperty.getUnitPrice());
					if (existGrantProperty.getPropertyNum() <= 0) {
						propertyDao.deleteGrantProperty(existGrantProperty.getGrantPropertyId());
					} else {
						propertyDao.updateGrantProperty(existGrantProperty);
					}
				}
			}
		}
	}
	
	/**
	 * 更新报废资产表
	 */
	public void updateScrapPropertyByFlow(Apply apply) {
		ScrapProperty scrapProperty = ScrapProperty.initScrapProperty(apply);
		ScrapProperty existScrapProperty = propertyDao.getScrapPropertyByAttribute(scrapProperty);
		if (apply.getApplyStatus().equals(ApplyStatus.APPROVE.getDesc())) {
			if (apply.getApplyType().equals(ApplyType.SCRAP.getDesc())) {
				if (existScrapProperty != null) {
					existScrapProperty.setPropertyNum(
							existScrapProperty.getPropertyNum() + apply.getPropertyNum());
					propertyDao.updateScrapProperty(existScrapProperty);
				} else {
					propertyDao.insertScrapProperty(scrapProperty);
				}
			}
		}
	}
}
