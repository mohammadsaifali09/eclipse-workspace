package org.jsp.springpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBaby {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("baby.xml");
		Baby baby = context.getBean(Baby.class);
		baby.getIceCream().eat();
	}
}
