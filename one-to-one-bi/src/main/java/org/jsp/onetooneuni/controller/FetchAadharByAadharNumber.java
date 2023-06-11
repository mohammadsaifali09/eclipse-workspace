package org.jsp.onetooneuni.controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetooneuni.dto.AadharCard;

public class FetchAadharByAadharNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter aadhar number to print your details");
		long anumber = scanner.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String query = "select a from AadharCard a where a.number=?1";
		Query q = manager.createQuery(query);
		q.setParameter(1, anumber);
		AadharCard card = (AadharCard) q.getSingleResult();
		if (card != null) {
			System.out.println("Id: " + card.getId());
			System.out.println("Aadhar no : " + card.getNumber());
			System.out.println("Dob : " + card.getDob());
		} else {
			System.err.println("Invalid aadhar number");
		}
	}
}
