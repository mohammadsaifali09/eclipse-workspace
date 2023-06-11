package org.jsp.compositekeydemo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.compositekeydemo.dto.User;
import org.jsp.compositekeydemo.dto.UserId;

public class FetchUserById {
	public static void main(String[] args) {
		System.out.println("Enter your phone number and email id to display details");
		Scanner sc = new Scanner(System.in);
		long phone = sc.nextLong();
		String email = sc.next();
		UserId id = new UserId();
		id.setEmail(email);
		id.setPhone(phone);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		User u = manager.find(User.class, id);
		if (u != null) {
			System.out.println("Phone Number: " + u.getId().getPhone());
			System.out.println("Email Id: " + u.getId().getEmail());
			System.out.println("Name: " + u.getName());
		} else {
			System.err.println("Invalid Phone Number or Email");
		}
	}
}
