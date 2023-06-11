package org.jsp.springlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Test implements InitializingBean, DisposableBean {
	static {
		System.out.println("Test class is loaded into JVM memory");
	}

	public Test() {
		System.out.println("The Object is getting created");
	}

	{
		System.out.println("The Test object is getting loaded");
	}

	public void destroy() throws Exception {
		System.out.println("Test object is destroyed");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Test object is initialized");
	}

}
