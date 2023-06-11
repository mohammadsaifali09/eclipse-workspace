package org.jsp.annotationdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBike {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Car car = context.getBean(Car.class);
		car.start();
		Bike bike = context.getBean(Bike.class);
		bike.start();
	}
}
