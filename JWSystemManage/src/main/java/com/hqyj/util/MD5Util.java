package com.hqyj.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util {
	// 在注册的时候输入的密码
	private String userPassword;
	// 将用户名用作盐
	private String userName;

	public String getPasswordByMD5(String password, String salt) {
		String simpleHash = new SimpleHash("MD5", password, salt, 1024).toString();
		return simpleHash;
	}
}
