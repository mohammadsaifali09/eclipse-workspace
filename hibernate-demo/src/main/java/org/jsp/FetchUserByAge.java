package org.jsp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByAge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age to print the details");
		int age = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery("select u from User u where u.age=?1");
		q.setParameter(1, age);
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
			System.err.println("No user found with the age: " + age);
		}
	}
}
