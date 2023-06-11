package org.jsp.onetomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetomanyuni.dto.Hospital;

public class FetchHospitalId {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter your id to display the details");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Hospital h = manager.find(Hospital.class, id);
		if (h != null) {
			System.out.println("Id: " + h.getId());
			System.out.println("Name: " + h.getName());
			System.out.println("Founder: " + h.getFounder());
			System.out.println("GST: " + h.getGst());
		} else {
			System.err.println("Invalid Id");
		}
	}
}
