package org.jsp.springpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDepartment {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dept.xml");
		Department department = context.getBean(Department.class);
		System.out.println(department.getNames());
		System.out.println(department.getEids());
		System.out.println(department.getDetails());
	}
}
