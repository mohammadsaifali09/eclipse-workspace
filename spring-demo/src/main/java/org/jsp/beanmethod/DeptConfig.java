package org.jsp.beanmethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.jsp.beanmethod")
public class DeptConfig {
	@Bean
	public List<String> getList() {
		return new ArrayList<String>();
	}

	@Bean
	public Set<Integer> getSet() {
		return new HashSet<Integer>();
	}
	
}
