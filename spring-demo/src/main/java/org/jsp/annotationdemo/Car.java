package org.jsp.annotationdemo;

import org.springframework.stereotype.Component;

@Component
public class Car {
	public void start() {
		System.out.println("Car has been started");
	}
}
