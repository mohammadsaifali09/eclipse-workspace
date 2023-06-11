package org.jsp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser
{
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your existing id to update");
		int id=scanner.nextInt();
		System.out.println("Enter your name,age,phone and password to update");
		String name=scanner.next();
		int age=scanner.nextInt();
		long phone=scanner.nextLong();
		String password=scanner.next();
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		user.setPhone(phone);
		user.setPassword(password);
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		session.update(user);
		Transaction t=session.beginTransaction();
		t.commit();
		System.out.println("User details are updated");
	}
}
