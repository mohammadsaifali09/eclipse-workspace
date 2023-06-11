package org.jsp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {
	public static void main(String[] args) {
		User u=new User();
		u.setName("Md Saif Ali");
		u.setAge(23);
		u.setPhone(8809833);
		u.setPassword("s123");
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		s.save(u);
		Transaction t=s.beginTransaction();
		t.commit();
		System.out.println("User saved with Id: "+u.getId());
	}
}
