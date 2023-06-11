package org.jsp.manytomanyuni.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;

public class SaveBatchAndStudent {
	public static void main(String[] args) {
		Batch b1 = new Batch();
		b1.setCode("SEHA5");
		b1.setSubject("Hibernate");
		Batch b2 = new Batch();
		b2.setCode("SEJA35");
		b2.setSubject("J2EE");
		Batch b3 = new Batch();
		b3.setCode("SESM21");
		b3.setSubject("Spring");
		Student s1 = new Student();
		s1.setName("Virat Kohli");
		s1.setPerc(75);
		s1.setBatches(new ArrayList<Batch>(Arrays.asList(b1,b2,b3)));
		Student s2 = new Student();
		s2.setName("Rohit Sharma");
		s2.setPerc(60);
		s2.setBatches(new ArrayList<Batch>(Arrays.asList(b1,b2,b3)));
		Student s3 = new Student();
		s3.setName("MS Dhoni");
		s3.setPerc(90.99);
		s3.setBatches(new ArrayList<Batch>(Arrays.asList(b1,b2,b3)));
		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		b3.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
	}
}
