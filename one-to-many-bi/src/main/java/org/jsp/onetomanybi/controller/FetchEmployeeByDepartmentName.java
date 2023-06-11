package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Employee;

public class FetchEmployeeByDepartmentName {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dName to display employee details");
		String dName = sc.nextLine();
		String qry = "select d.emps from Department d where d.name=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, dName);
		List<Employee> employees = q.getResultList();
		if (employees.size() > 0) {
			for (Employee e : employees) {
				System.out.println(e);
			}
		} else {
			System.err.println("Invalid dName");
		}
	}
}
