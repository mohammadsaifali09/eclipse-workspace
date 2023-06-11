package org.jsp.annotationdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestPerson {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Person.class);
		Person person = context.getBean(Person.class);
		System.out.println("Name: " + person.getName());
		System.out.println("Age: " + person.getAge());
		System.out.println("Phone: " + person.getPhone());
	}
}