package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Student;

public class FetchStudentById {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to display student");
		int id = sc.nextInt();
		String qry = "select s from Student s where s.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		List<Student> students = q.getResultList();
		if (students.size() > 0) {
			for (Student st : students) {
				System.out.println(st);
			}
		} else {
			System.err.println("Invalid Id");
		}
	}
}
