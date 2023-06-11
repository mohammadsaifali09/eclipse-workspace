package org.jsp.manytomanyuni.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", perc=" + perc + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double perc;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
	private List<Batch> batches;

	public List<Batch> getBatches() {
		return batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

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

	public double getPerc() {
		return perc;
	}

	public void setPerc(double perc) {
		this.perc = perc;
	}

}
