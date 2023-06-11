package org.jsp.springlifecycle;

public class Demo {
	static {
		System.out.println("Demo class is loaded into JVM memory");
	}

	{
		System.out.println("Demo object is loaded");
	}

	public void hii() {
		System.out.println("hii from Demo Object");
	}

	public void byee() {
		System.out.println("byee from Demo Object");
	}
}
