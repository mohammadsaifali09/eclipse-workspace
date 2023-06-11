package org.jsp.onetooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetooneuni.dto.AadharCard;
import org.jsp.onetooneuni.dto.Person;

public class FetchPersonByAadharId {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter aadhar id to print your details");
		int aid=scanner.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		AadharCard card =manager.find(AadharCard.class, aid);
		if (card != null) {
			Person p=card.getP();
			System.out.println("Id: "+p.getId());
			System.out.println("Name : "+p.getName());
			System.out.println("Phone : "+p.getPhone());
		} else {
			System.err.println("Invalid Id");
		}
	}
}
