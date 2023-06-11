package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Employee;

public class FetchEmployeeByDepartmentId {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dId to display employee details");
		int dId = sc.nextInt();
		String qry = "select d.emps from Department d where d.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, dId);
		List<Employee> employees = q.getResultList();
		if (employees.size() > 0) {
			for (Employee e : employees) {
				System.out.println(e);
			}
		} else {
			System.err.println("Invalid dId");
		}
	}
}
