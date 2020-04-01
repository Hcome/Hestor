package com.heshouyang.springboot.Modules.test.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//注入bean
@Component
//其他源路径的配置文件
@PropertySource("classpath:config/application.properties")
//公共前缀
@ConfigurationProperties(prefix = "com.heshouyang")
public class configBean {
	
	private String name;
	
	private int age;
	
	private String desc;
	
	private String random;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

}
