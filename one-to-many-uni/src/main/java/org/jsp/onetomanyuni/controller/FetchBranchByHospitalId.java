package org.jsp.onetomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanyuni.dto.Branch;

public class FetchBranchByHospitalId {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter hospitalid to display branch");
		int id = sc.nextInt();
		String qry = "select h.branches from Hospital h where h.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		List<Branch> branchs = q.getResultList();
		if (branchs.size() > 0) {
			for (Branch b : branchs) {
				System.out.println(b);
			}
		} else {
			System.err.println("Invalid HospitalId");
		}
	}
}
