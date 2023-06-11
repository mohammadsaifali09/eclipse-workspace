package org.jsp.onetooneuni.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetooneuni.dto.AadharCard;
import org.jsp.onetooneuni.dto.Person;

public class SavePersonAndAadhar {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Person p = new Person();
		p.setName("saif");
		p.setPhone(8809833242L);
		AadharCard card = new AadharCard();
		card.setDob(LocalDate.parse("1999-04-11"));
		card.setNumber(123412341234L);
		p.setCard(card);// Assign aadhar card for person
		manager.persist(p);
		transaction.begin();
		transaction.commit();

	}
}
