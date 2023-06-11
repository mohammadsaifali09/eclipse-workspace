package org.jsp.lifecycledemo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.lifecycledemo.dto.User;

public class DeleteUser {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		User u = manager.find(User.class, 1);// Persistent state
		if (u != null) {
			manager.remove(u);// Removed State
		} else {
			System.err.println("Invalid id");
		}
		transaction.begin();
		transaction.commit();
	}
}
