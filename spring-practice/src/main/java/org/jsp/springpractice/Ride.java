package org.jsp.springpractice;

public class Ride {
	private Vehicle vehicle;

	public void startRide() {
		vehicle.start();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
