package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Student;

public class FetchStudentByBatchId {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batchId to display student");
		int bid = sc.nextInt();
		String qry = "select b.students from Batch b where b.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, bid);
		List<Student> students = q.getResultList();
		if (students.size() > 0) {
			for (Student st : students) {
				System.out.println(st);
			}
		} else {
			System.err.println("Invalid BatchId");
		}
	}
}
