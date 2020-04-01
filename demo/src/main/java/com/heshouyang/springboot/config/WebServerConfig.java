package com.heshouyang.springboot.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @Configuration 配置注解
 * @AutoConfigureAfter 修盖默认的web服务器的配置文件，并覆盖
 * @author Administrator
 *
 */
@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebServerConfig {
	@Bean
	public Connector connector() {
		Connector connector = new Connector();
		connector.setScheme("http");
		connector.setPort(8088);
		return connector;
		
	}
	@Bean
	public WebServerFactory webServerFactory() {
		
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(connector());
		return tomcat;
	}

}
