package org.jsp.springpractice;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Department {
	private List<String> names;
	private Set<Integer> eids;
	private Map<Integer, String> details;

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public Set<Integer> getEids() {
		return eids;
	}

	public void setEids(Set<Integer> eids) {
		this.eids = eids;
	}

	public Map<Integer, String> getDetails() {
		return details;
	}

	public void setDetails(Map<Integer, String> details) {
		this.details = details;
	}

}
