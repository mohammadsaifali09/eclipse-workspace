package org.jsp.springprc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestRide {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(RideConfig.class);
	Ride ride=context.getBean(Ride.class);
	ride.getVehicle().start();
}
}
