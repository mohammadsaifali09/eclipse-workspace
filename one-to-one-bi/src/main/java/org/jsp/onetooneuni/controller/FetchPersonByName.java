package org.jsp.onetooneuni.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.Person;

public class FetchPersonByName {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query query = manager.createQuery("select p from Person p where p.name=?1");
		query.setParameter(1, "saif");
		List<Person> persons = query.getResultList();
		for (Person p : persons) {
			System.out.println(p);
			System.out.println(p.getCard().getDob());
			System.out.println(p.getCard().getNumber());
		}
	}
}
