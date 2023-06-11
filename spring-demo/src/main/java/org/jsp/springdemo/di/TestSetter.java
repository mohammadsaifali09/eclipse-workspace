package org.jsp.springdemo.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetter {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("car-engine.xml");
		Car car = context.getBean(Car.class);
		car.startEngine();
	}
}
