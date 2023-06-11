package org.jsp.onetooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.Person;

public class FetchPersonByAadharNumber2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter aadhar id to print your details");
		long anumber = scanner.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String query = "select p from Person p where p.card.number=?1";
		Query q = manager.createQuery(query);
		q.setParameter(1, anumber);
		Person p = (Person) q.getSingleResult();
		if (p != null) {
			System.out.println("Id: "+p.getId());
			System.out.println("Name : "+p.getName());
			System.out.println("Phone : "+p.getPhone());
		} else {
			System.err.println("Invalid aadhar number");
		}
	}
}
