package com.heshouyang.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ScProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScProductApplication.class, args);
	}

}
