package org.jsp.onetomanyuni.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanyuni.dto.Branch;
import org.jsp.onetomanyuni.dto.Hospital;

public class SaveHospitalAndBranch {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	Hospital h=new Hospital();
	h.setName("Manipal");
	h.setFounder("XYZ");
	h.setGst("MP123");
	Branch b1=new Branch();
	b1.setEmail("mb@gmail.com");
	b1.setName("Manipal Bangalore");
	b1.setPhone(777);
	Branch b2=new Branch();
	b2.setEmail("mm@gmail.com");
	b2.setName("Manipal Bangalore");
	b2.setPhone(877);
	Branch b3=new Branch();
	b3.setEmail("mmys@gmail.com");
	b3.setName("Manipal Mysore");
	b3.setPhone(977);
//	Adding branches for hospital
/*	List<Branch> branchs=new ArrayList<Branch>();
	branchs.add(b1);
	branchs.add(b2);
	branchs.add(b3);
	h.setBranches(branchs);
*/
	h.setBranches(new ArrayList<Branch>(Arrays.asList(b1,b2,b3)));
	manager.persist(h);
	transaction.begin();
	transaction.commit();
}
}
