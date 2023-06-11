package org.jsp.hibernatejpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hibernatejpademo.dto.Person;

public class DeletePerson {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id to delete the details");
		int id = sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Person p = manager.find(Person.class, id);
		if (p != null) {
			manager.remove(p);
			transaction.begin();
			transaction.commit();
		} else {
			System.err.println("Invalid Id");
		}
	}
}
