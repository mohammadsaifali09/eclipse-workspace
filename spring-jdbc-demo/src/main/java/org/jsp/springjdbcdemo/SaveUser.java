package org.jsp.springjdbcdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SaveUser {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		JdbcTemplate template = context.getBean(JdbcTemplate.class);
		int r = template.update("insert into user values(1,'Md Saif Ali',8809833242,'saif123')");
		System.out.println(r + " rows inserted");
	}
}
