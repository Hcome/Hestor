package com.hqyj.test;

import java.io.IOException;
import java.sql.SQLException;

import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;

import com.hqyj.util.MD5Util;

public class Test {

	public static void main(String[] args)
			throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		MD5Util m = new MD5Util();
		System.out.println(m.getPasswordByMD5("123", "zs"));
	}

}
