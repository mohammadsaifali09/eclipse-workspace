package org.jsp.springdemo.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructor {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("user-product.xml");
		Product product = context.getBean(Product.class);
		product.display();
	}
}
