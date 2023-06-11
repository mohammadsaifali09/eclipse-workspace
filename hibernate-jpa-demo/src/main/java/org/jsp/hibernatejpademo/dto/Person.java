package org.jsp.hibernatejpademo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(value = { @NamedQuery(name = "findAll", query = "select p from Person p"),
		@NamedQuery(name = "findByName", query = "select p from Person p where p.name=?1"),
		@NamedQuery(name = "findByPhone", query = "select p from Person p where p.phone=?1"),
		@NamedQuery(name = "findByPhoneAndPassword", query = "select p from Person p where p.phone=?1 and p.password=?2") })
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, password;
	private long phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

}
