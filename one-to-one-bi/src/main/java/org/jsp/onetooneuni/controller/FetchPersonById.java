package org.jsp.onetooneuni.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetooneuni.dto.Person;

public class FetchPersonById {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person person = manager.find(Person.class, 1);
		if (person != null) {
			System.out.println("Id: "+person.getId());
			System.out.println("Name: "+person.getName());
			System.out.println("Phone: "+person.getPhone());
			System.out.println("Aadhar no : "+person.getCard().getNumber());
		} else {
			System.err.println("Invalid Id");
		}
	}
}
