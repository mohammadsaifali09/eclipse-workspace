package org.jsp.manytooneuni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytooneuni.dto.Answer;
import org.jsp.manytooneuni.dto.Question;

public class SaveQuestionAndAnswer {
	public static void main(String[] args) {
		Question q = new Question();
		q.setQuestion("What is Java?");
		q.setQuestionBy("Trainer");
		Answer a1 = new Answer();
		a1.setAnswer("Java is a high level programming language.");
		a1.setAnsweredBy("Ranjit");
		a1.setQ(q);
		Answer a2 = new Answer();
		a2.setAnswer("Java is a object oriented programming language.");
		a2.setAnsweredBy("Saif");
		a2.setQ(q);
		Answer a3 = new Answer();
		a3.setAnswer("Java is a platform independent programming language.");
		a3.setAnsweredBy("Awhan");
		a3.setQ(q);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		manager.persist(a1);
		manager.persist(a2);
		manager.persist(a3);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
	}
}
