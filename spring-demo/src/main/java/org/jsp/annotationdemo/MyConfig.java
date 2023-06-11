package org.jsp.annotationdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.jsp")
public class MyConfig {
	@Bean(name = "bike")
	public Bike getBike() {
		return new Bike();
	}
}
