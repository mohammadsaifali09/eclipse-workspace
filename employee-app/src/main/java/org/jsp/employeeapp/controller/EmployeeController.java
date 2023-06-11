package org.jsp.employeeapp.controller;

import java.util.Scanner;
import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.dto.Employee;

public class EmployeeController {

	static Scanner sc = new Scanner(System.in);
	static EmployeeDao dao = new EmployeeDao();

	public static void main(String[] args) {
		System.out.println("1.Register Employee");
		System.out.println("2.Login Employee");
		System.out.println("3.Update Employee");
		System.out.println("4.Delete Employee");

		int choice = sc.nextInt();

		switch (choice) {
		case 1: {
			register();
			break;
		}
		case 2: {
			login();
			break;
		}

		case 3: {
			update();
			break;
		}

		case 4: {
			delete();
			break;
		}

		default: {
			System.out.println("Invalid choice");
		}
		}
	}

	private static void register() {
		System.out.println("Enter name,desg,salary,phone and password");
		String name = sc.next();
		String desg = sc.next();
		double salary = sc.nextDouble();
		long phone = sc.nextLong();
		String password = sc.next();
		Employee e = new Employee();
		e.setName(name);
		e.setDesg(desg);
		e.setSalary(salary);
		e.setPhone(phone);
		e.setPassword(password);
		dao.saveEmployee(e);
		System.out.println("Employee saved with id: " + e.getId());
	}

	private static void login() {
		System.out.println("Enter your phone number and password");
		long phone = sc.nextLong();
		String password = sc.next();
		Employee e = dao.verify(phone, password);
		if (e != null) {
			System.out.println("Login succesfull");
			System.out.println("Name: " + e.getName());
			System.out.println("Desg: " + e.getDesg());
			System.out.println("Salary: " + e.getSalary());
			System.out.println("Phone: " + e.getPhone());
		} else {
			System.err.println("Ivalid phone number or password");
		}
	}

	private static void update() {
		System.out.println("Enter your existing id,name,desg,salary,phone and password to update");
		int id = sc.nextInt();
		String name = sc.next();
		String desg = sc.next();
		double salary = sc.nextDouble();
		long phone = sc.nextLong();
		String password = sc.next();
		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setDesg(desg);
		e.setSalary(salary);
		e.setPhone(phone);
		e.setPassword(password);
		dao.updateEmployee(e);
		System.out.println("Employee updated with id: " + e.getId());
	}

	private static void delete() {
		System.out.println("Enter your existing id to delete");
		int id = sc.nextInt();
		if (dao.deleteEmployee(id)) {
			System.out.println("Employee are deleted");
		} else {
			System.err.println("Ivalid id");
		}
	}
}
