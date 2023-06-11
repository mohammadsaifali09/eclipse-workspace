package org.jsp.springlifecycle;

public class LifeCycle {
	static {
		System.out.println("LifeCycle class is loaded into JVM memory");
	}

	{
		System.out.println("LifeCycle object is loaded");
	}

	public void hii() {
		System.out.println("hii from LifeCycle Object");
	}

	public void byee() {
		System.out.println("byee from LifeCycle Object");
	}
}
