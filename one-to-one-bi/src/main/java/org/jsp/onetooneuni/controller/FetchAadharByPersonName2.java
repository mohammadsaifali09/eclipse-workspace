package org.jsp.onetooneuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.AadharCard;

public class FetchAadharByPersonName2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name to display aadhar details");
		String pname = scanner.next();
		String query = "select a from AadharCard a where a.p.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(query);
		q.setParameter(1, pname);
		List<AadharCard> cards =q.getResultList();
		if (cards.size()>0) {
			for (AadharCard a : cards) {
				System.out.println(a);
			}
		} else {
			System.err.println("Invalid Name");
		}
	}
}
