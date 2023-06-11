package org.jsp.onetomanybi.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanybi.dto.Department;
import org.jsp.onetomanybi.dto.Employee;

public class SaveEmpAndDept {
	public static void main(String[] args) {
		Department department = new Department();
		department.setName("Development");
		department.setLocation("BTM Layout");
		Employee e1 = new Employee();
		e1.setName("ABC");
		e1.setDesg("Trainer");
		e1.setSalary(686678);
		e1.setDept(department);
		Employee e2 = new Employee();
		e2.setName("XYZ");
		e2.setDesg("HR");
		e2.setSalary(686000);
		e2.setDept(department);
		Employee e3 = new Employee();
		e3.setName("PQR");
		e3.setDesg("Trainer");
		e3.setSalary(60000);
		e3.setDept(department);
		department.setEmps(new ArrayList<Employee>(Arrays.asList(e1, e2, e3)));
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(department);
		transaction.begin();
		transaction.commit();
	}
}
