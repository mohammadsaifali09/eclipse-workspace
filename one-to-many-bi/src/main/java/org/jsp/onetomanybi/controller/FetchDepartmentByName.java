package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;

public class FetchDepartmentByName {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name to display department details");
		String name = sc.nextLine();
		String qry = "select d from Department d where d.name=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		List<Department> departments = q.getResultList();
		if (departments.size() > 0) {
			for (Department d : departments) {
				System.out.println(d);
			}
		} else {
			System.err.println("Invalid Name");
		}
	}
}
