package org.jsp.springpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRide {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ride.xml");
		Ride ride = context.getBean(Ride.class);
		ride.startRide();
	}
}
