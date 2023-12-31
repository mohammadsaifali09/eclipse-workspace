package org.jsp.onetooneuni.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long phone;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="aadharcard_id")
	private AadharCard card;

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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public AadharCard getCard() {
		return card;
	}

	public void setCard(AadharCard card) {
		this.card = card;
	}
}
