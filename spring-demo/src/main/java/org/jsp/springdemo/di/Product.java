package org.jsp.springdemo.di;

public class Product {
	private int pid;
	private String name;

	public void display() {
		System.out.println("Product id: " + pid);
		System.out.println("Product name: " + name);
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
