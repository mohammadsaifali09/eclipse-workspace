package org.jsp.springjdbcdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		JdbcTemplate template = context.getBean(JdbcTemplate.class);
		template.execute(
				"create table user (id int not null,name varchar(45) not null,phone bigint not null,password varchar(45) not null)");
		System.out.println("Table is created succefully");
	}
}
