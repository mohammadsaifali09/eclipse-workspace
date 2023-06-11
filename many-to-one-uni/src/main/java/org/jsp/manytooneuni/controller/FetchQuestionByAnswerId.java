package org.jsp.manytooneuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytooneuni.dto.Question;

public class FetchQuestionByAnswerId {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter answerid to display question");
		int aid = sc.nextInt();
		String qry = "select a.q from Answer a where a.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, aid);
		List<Question> questions = q.getResultList();
		if (questions.size() > 0) {
			for (Question question : questions) {
				System.out.println(question);
			}
		} else {
			System.err.println("Invalid AnswerId");
		}
	}
}
