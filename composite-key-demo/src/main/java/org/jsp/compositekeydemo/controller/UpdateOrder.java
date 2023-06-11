package org.jsp.compositekeydemo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositekeydemo.dto.FoodOrder;

public class UpdateOrder {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder order = manager.find(FoodOrder.class, 1);
		if (order != null) {
			order.setLocation("BTM Layout Qspiders");
			order.setCost(450);
			manager.merge(order);
			transaction.begin();
			transaction.commit();
		} else {
			System.err.println("Invalid Id");
		}
	}
}
