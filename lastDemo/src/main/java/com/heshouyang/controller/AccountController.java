package com.heshouyang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.heshouyang.entity.Account;
import com.heshouyang.service.AccountService;
import com.heshouynag.model.vo.SearchInfo;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService as;
	
	@RequestMapping("/goAccountAllUse.do")
	public String goAccountAllUse() {
		return "account/allAccountUse";
	}
	
	@RequestMapping("/accountAllUse.do")
	@ResponseBody
	public String accountAllUse(String makectName) {
		Integer accountAllUse = as.accountAllIsUseByMakectName(makectName);
		System.out.println(accountAllUse);
		String str = accountAllUse.toString();
		return str;
	}
	
	@RequestMapping("/goAssetsRecording.do")
	public String  goAssetsRecording() {
		return "account/assetsRecording";
	}
	
	@RequestMapping("/assetsRecording.do")
	@ResponseBody
	public PageInfo<Account> assetsRecording(SearchInfo searchInfo) {
		PageInfo<Account> info = as.quertAccount(searchInfo.getCurrentPage());
		return info;
	}
}
