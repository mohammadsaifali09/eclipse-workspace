package org.jsp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your phone and password to print the details");
		long phone = sc.nextLong();
		String password = sc.next();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		List<User> users = q.getResultList();
		if (users.size() > 0) {
			for (User u : users) {
				System.out.println("Id: " + u.getId());
				System.out.println("Name: " + u.getName());
				System.out.println("Age: " + u.getAge());
				System.out.println("Phone: " + u.getPhone());
				System.out.println("----------------------");
			}
		} else {
			System.err.println("No user found with the phone and password: " + phone + " and " + password);
		}
	}
}
