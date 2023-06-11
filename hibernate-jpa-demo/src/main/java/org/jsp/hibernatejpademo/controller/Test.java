package org.jsp.hibernatejpademo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hibernatejpademo.dto.Employee;

public class Test {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("Abc");
		e.setPhone(888);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		manager.persist(e);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("person saved with id: " + e.getId());
	}
}
