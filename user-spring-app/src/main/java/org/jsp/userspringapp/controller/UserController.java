package org.jsp.userspringapp.controller;

import java.util.Scanner;

import org.jsp.userspringapp.UserConfig;
import org.jsp.userspringapp.dao.UserDao;
import org.jsp.userspringapp.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserController {
	static Scanner sc = new Scanner(System.in);
	static UserDao dao;

	static {
		ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		dao = context.getBean(UserDao.class);
	}

	public static void main(String[] args) {
		System.out.println("1.Save User");
		System.out.println("2.Update User");
		System.out.println("3.Verify User");
		System.out.println("4.Delete User");

		int choice = sc.nextInt();

		switch (choice) {
		case 1: {
			save();
			break;
		}
		case 2: {
			update();
			break;
		}

		case 3: {
			verify();
			break;
		}

		case 4: {
			delete();
			break;
		}

		default: {
			System.err.println("Invalid choice");
		}

		}
	}

	public static void save() {
		System.out.println("Enter name,phone,email and password");
		String name = sc.next();
		long phone = sc.nextLong();
		String email = sc.next();
		String password = sc.next();
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		user = dao.saveUser(user);
		System.out.println("User saved with Id: " + user.getId());
	}

	public static void verify() {
		System.out.println("Enter your phone number and password");
		long phone = sc.nextLong();
		String password = sc.next();
		User user = dao.verifyUser(phone, password);
		if (user != null) {
			System.out.println("Login Succesfully");
			System.out.println("Id: " + user.getId());
			System.out.println("Name: " + user.getName());
			System.out.println("Phone: " + user.getPhone());
			System.out.println("Email: " + user.getEmail());
		} else {
			System.err.println("Invalid phone number or password");
		}
	}

	private static void update() {
		System.out.println("Enter your existing id,name,phone,email and password to update");
		int id = sc.nextInt();
		String name = sc.next();
		long phone = sc.nextLong();
		String email = sc.next();
		String password = sc.next();
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);
		user = dao.updateUser(user);
		System.out.println("Employee updated with Id: " + user.getId());
	}

	private static void delete() {
		System.out.println("Enter your existing id to delete");
		int id = sc.nextInt();
		if (dao.deleteUser(id)) {
			System.out.println("Employee are deleted");
		} else {
			System.err.println("Invalid id");
		}
	}
}
