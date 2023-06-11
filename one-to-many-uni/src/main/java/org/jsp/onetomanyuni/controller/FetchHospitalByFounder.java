package org.jsp.onetomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanyuni.dto.Hospital;

public class FetchHospitalByFounder {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter founder to display hospital");
		String founder = sc.nextLine();
		String qry = "select h from Hospital h where h.founder=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, founder);
		List<Hospital> hospitals = q.getResultList();
		if (hospitals.size() > 0) {
			for (Hospital h : hospitals) {
				System.out.println(h);
			}
		} else {
			System.err.println("Invalid Founder");
		}
	}
}
