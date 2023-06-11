package org.jsp.hibernatejpademo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.hibernatejpademo.dto.Person;

public class FindByPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your phone and password to print the details");
		long phone = sc.nextLong();
		String password = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("findByPhoneAndPassword");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		List<Person> persons = q.getResultList();
		for (Person p : persons) {
			System.out.println(p);
		}
	}
}
