package org.jsp.hibernatejpademo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hibernatejpademo.dto.Person;

public class SavePerson {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Abc");
		p.setPhone(888);
		p.setPassword("a123");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		manager.persist(p);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("person saved with id: " + p.getId());
	}
}
