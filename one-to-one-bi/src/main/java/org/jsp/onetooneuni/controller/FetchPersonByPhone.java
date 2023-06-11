package org.jsp.onetooneuni.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.Person;

public class FetchPersonByPhone {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query query = manager.createQuery("select p from Person p where p.phone=?1");
		query.setParameter(1, 8809833242L);
		List<Person> persons = query.getResultList();
		for (Person p : persons) {
			System.out.println(p);
			System.out.println(p.getCard().getDob());
			System.out.println(p.getCard().getNumber());
		}
	}
}
