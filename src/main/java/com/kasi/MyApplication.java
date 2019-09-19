package com.kasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;


@SpringBootApplication
public class MyApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MyApplication.class);
		ConfigurableEnvironment env = new StandardEnvironment();
		application.setEnvironment(env);
		//		ApplicationPropertiesUtil.initApplicationProperties(env);
		application.run(args);
	}
}
