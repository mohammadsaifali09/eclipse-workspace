package org.jsp.babyprogram;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBaby {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BabyConfig.class);
		Baby baby = context.getBean(Baby.class);
		baby.getIceCream().eat();
	}
}
