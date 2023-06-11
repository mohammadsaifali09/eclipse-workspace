package org.jsp.springdemo.di;

public class Car {
	private Engine e;

	public void startEngine() {
		e.start();
	}

	public Engine getE() {
		return e;
	}

	public void setE(Engine e) {
		this.e = e;
	}

}
