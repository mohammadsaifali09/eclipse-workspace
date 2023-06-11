package org.jsp.springdemo;

public class Employee {
	private int eid;
	private String name;

	public Employee() {
	}

	public Employee(int eid, String name) {
		this.eid = eid;
		this.name = name;
	}

	public void display() {
		System.out.println("Employee Id: " + eid);
		System.out.println("Name: " + name);
	}

}
