package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;

public class FetchDepartmentByEmployeeDesignation {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter eDesg to display department details");
		String eDesg = sc.nextLine();
		String qry = "select e.dept from Employee e where e.desg=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, eDesg);
		List<Department> departments = q.getResultList();
		if (departments.size() > 0) {
			for (Department d : departments) {
				System.out.println(d);
			}
		} else {
			System.err.println("Invalid eDesg");
		}
	}
}
