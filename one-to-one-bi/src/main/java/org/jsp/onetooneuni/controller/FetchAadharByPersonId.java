package org.jsp.onetooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetooneuni.dto.AadharCard;
import org.jsp.onetooneuni.dto.Person;

public class FetchAadharByPersonId {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter person id to print your details");
		int pid=scanner.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person person = manager.find(Person.class, pid);
		if (person != null) {
			AadharCard card=person.getCard();
			System.out.println("Id: "+card.getId());
			System.out.println("Aadhar no : "+card.getNumber());
			System.out.println("Dob : "+card.getDob());
		} else {
			System.err.println("Invalid Id");
		}
	}
}
