package org.jsp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteUser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your existing id to delete the record");
		int id = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		User u = s.get(User.class, id);
		if (u != null) {
			s.delete(u);
			Transaction t = s.beginTransaction();
			t.commit();
			System.out.println("Your record is deleted");
		} else {
			System.err.println("You have entered an Invalid Id");
		}
	}
}
