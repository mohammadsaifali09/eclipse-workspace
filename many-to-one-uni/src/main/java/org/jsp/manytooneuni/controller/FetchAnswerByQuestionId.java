package org.jsp.manytooneuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytooneuni.dto.Answer;

public class FetchAnswerByQuestionId {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter question id to display answers for that question");
		int qid = sc.nextInt();
		String qry = "select a from Answer a where a.q.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, qid);
		List<Answer> answers = q.getResultList();
		if (answers.size() > 0) {
			for (Answer a : answers) {
				System.out.println(a);
			}
		} else {
			System.err.println("Invalid Question Id");
		}
	}
}
