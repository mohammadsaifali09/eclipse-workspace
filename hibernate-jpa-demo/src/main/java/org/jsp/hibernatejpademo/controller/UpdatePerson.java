package org.jsp.hibernatejpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hibernatejpademo.dto.Person;

public class UpdatePerson {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the existing id");
		int id=sc.nextInt();
		System.out.println("Enter your name,phone and password to update");
		String name=sc.next();
		long phone=sc.nextLong();
		String paassword=sc.next();
		Person p = new Person();
		p.setId(id);
		p.setName(name);
		p.setPhone(phone);
		p.setPassword(paassword);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		manager.merge(p);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
	}
}
