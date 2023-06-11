package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;

public class FetchDepartmentById {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to display department details");
		int id = sc.nextInt();
		String qry = "select d from Department d where d.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		List<Department> departments = q.getResultList();
		if (departments.size() > 0) {
			for (Department d : departments) {
				System.out.println(d);
			}
		} else {
			System.err.println("Invalid Id");
		}
	}
}
