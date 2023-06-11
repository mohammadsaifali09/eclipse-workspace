package org.jsp.springlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("demo.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("demo1.xml");
		((ClassPathXmlApplicationContext) context).close();
	}
}
