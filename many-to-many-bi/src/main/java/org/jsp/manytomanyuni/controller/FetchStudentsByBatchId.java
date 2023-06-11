package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Student;

public class FetchStudentsByBatchId {
public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter batch id to display the details");
	int id = sc.nextInt();
	String qry = "select b.students from Batch b where b.id=?1";
	Query q = manager.createQuery(qry);
	q.setParameter(1, id);
	List<Student> students = q.getResultList();
	if (students.size() > 0) {
		for (Student b : students) {
			System.out.println(b);
		}
	} else {
		System.err.println("Invalid Batch Id");
	}
}
}
