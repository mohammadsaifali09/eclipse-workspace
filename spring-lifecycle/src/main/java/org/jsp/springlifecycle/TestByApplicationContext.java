package org.jsp.springlifecycle;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestByApplicationContext {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
		System.out.println(context.getBean("test"));
		System.out.println(context.getBean("test"));
		context.close();
	}
}
