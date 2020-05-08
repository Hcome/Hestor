package com.hqyj.erp.modules.common.controller;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.common.vo.Result;

/**
 * 公共页面控制器
 * @author: HymanHu
 * @date: 2019年10月29日
 */
@Controller
public class CommonController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private AccountService accountService;

	/**
	 * login页面
	 */
	@RequestMapping("/login")
	public String loginPage() {
		return "common/login";
	}
	
	/**
	 * 注册页面
	 */
	@RequestMapping("/register")
	public String registerPage() {
		return "common/register";
	}
	
	/**
	 * 用户注册
	 */
	@PostMapping(value="/doRegister", consumes="application/json")
	@ResponseBody
	public Result doRegister(@RequestBody User user) {
		user.initUserInfo();
		return accountService.inserOrUpdatetUser(user);
	}
	
	/**
	 * 用户登录
	 */
	@PostMapping(value="/doLogin", consumes="application/json")
	@ResponseBody
	public Result doLogin(@RequestBody User user) {
		user.initUserInfo();
		return accountService.getUserResult(user);
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping("/loginOut")
	public String loginOut() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "common/login";
	}
	
	/**
	 * indexpage
	 */
	@RequestMapping("/index")
	public String indexPage(HttpServletRequest request, ModelMap modelMap) {
		
	    Subject subject = SecurityUtils.getSubject();
	    LOGGER.debug("------------------" + subject.isRemembered());
	    LOGGER.debug("------------------" + subject.isAuthenticated());
	    
		User user = accountService.getUserByName((String)subject.getPrincipal());
		if (user == null) {
			return "common/login";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ipAddress = null;
		String serverName = null;
		String loacalUrl = request.getScheme() + "://" + request.getLocalAddr() 
			+ ":" + request.getServerPort() + request.getServletPath();
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			ipAddress = inetAddress.getHostAddress();
			serverName = inetAddress.getHostName();
		} catch (Exception e) {
			ipAddress = "无法获取ip";
		}
		
		modelMap.addAttribute("loginTime", sdf.format(new Date()));
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("userIp", ipAddress);
		modelMap.addAttribute("localIp", ipAddress);
		modelMap.addAttribute("serverName", serverName);
		modelMap.addAttribute("loacalUrl", loacalUrl);
		modelMap.addAttribute("template", "common/wellcome");
		
		request.getSession().setAttribute("userObject", user);
		
		return "index";
	}
}
