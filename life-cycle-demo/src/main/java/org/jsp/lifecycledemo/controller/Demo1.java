package org.jsp.lifecycledemo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.lifecycledemo.dto.User;

public class Demo1 {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		User u = new User();// Transient State
		u.setName("ABC");
		u.setPhone(8888);
		u.setPassword("a123");
		manager.persist(u);// Persistent State
		u.setName("Kohli");
		transaction.begin();
		transaction.commit();
		u.setName("Dhoni");
		u.setPhone(77778888);
		u.setPassword("d123");
		transaction.begin();
		transaction.commit();
		manager.detach(u);// Detached State
		u.setName("Rohit");
		u.setPhone(7788);
		u.setPassword("r123");
		transaction.begin();
		transaction.commit();
	}
}
