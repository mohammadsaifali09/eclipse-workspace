package org.jsp.onetooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.AadharCard;

public class FetchAadharByPersonPhone {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter person phone to print your details");
		long pphone = scanner.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String query = "select p.card from Person p where p.phone=?1";
		Query q = manager.createQuery(query);
		q.setParameter(1, pphone);
		AadharCard card = (AadharCard) q.getSingleResult();
		if (card != null) {
			System.out.println("Id: " + card.getId());
			System.out.println("Aadhar no : " + card.getNumber());
			System.out.println("Dob : " + card.getDob());
		} else {
			System.err.println("Invalid Phone");
		}
	}
}
