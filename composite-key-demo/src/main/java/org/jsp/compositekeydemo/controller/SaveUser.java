package org.jsp.compositekeydemo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositekeydemo.dto.User;
import org.jsp.compositekeydemo.dto.UserId;

public class SaveUser {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		UserId id = new UserId();
		id.setEmail("2@gmail.com");
		id.setPhone(8888);
		User user = new User();
		user.setId(id);
		user.setName("KL Rahul");
		user.setPassword("Athiya");
		manager.persist(user);
		transaction.begin();
		transaction.commit();
	}
}
