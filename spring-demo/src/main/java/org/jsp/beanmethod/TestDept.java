package org.jsp.beanmethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDept {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DeptConfig.class);
		Department department = context.getBean(Department.class);
		System.out.println(department.getIds());
		System.out.println(department.getNames());
	}
}