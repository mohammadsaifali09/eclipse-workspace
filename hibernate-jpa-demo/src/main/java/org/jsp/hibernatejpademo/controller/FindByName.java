package org.jsp.hibernatejpademo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.hibernatejpademo.dto.Person;

public class FindByName {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name to print the details");
		String name=sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("findByName");
		q.setParameter(1, name);
		List<Person> persons = q.getResultList();
		for (Person p : persons) {
			System.out.println(p);
		}
	}
}
