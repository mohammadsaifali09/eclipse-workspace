package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Student;

public class FetchStudentsBySubject {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your subject");
		String subject = sc.next();
		String qry = "select b.students from Batch b where b.subject=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, subject);
		List<Student> students = q.getResultList();
		if (students.size() > 0) {
			for (Student st : students) {
				System.out.println(st);
			}
		} else {
			System.err.println("Invalid subject");
		}
	}
}
