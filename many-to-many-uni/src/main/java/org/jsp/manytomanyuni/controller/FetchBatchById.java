package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Batch;

public class FetchBatchById {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to display batch");
		int id = sc.nextInt();
		String qry = "select b from Batch b where b.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		List<Batch> batchs = q.getResultList();
		if (batchs.size() > 0) {
			for (Batch b : batchs) {
				System.out.println(b);
			}
		} else {
			System.err.println("Invalid Id");
		}
	}
}
