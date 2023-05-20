package com.app.core;

import java.time.LocalDate;

/*
 * Objective : Accept vehicle details : chasisNo(string) : Unique ID, 
 * color(enum) , basePrice(double) , manufactureDate(LocalDate),
 * company,isAvailable

 */
public class Vehicle{
	private String chasisNo;
	// HAS-A : association , Vehicle HAS-A Color
	private Color vehicleColor;
	private double basePrice;
	private LocalDate manufactureDate;
	private String company;
	private boolean isAvailable;

	public Vehicle(String chasisNo, Color vehicleColor, double basePrice, LocalDate manufactureDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleColor = vehicleColor;
		this.basePrice = basePrice;
		this.manufactureDate = manufactureDate;
		this.company = company;
		this.isAvailable = true;
	}
	
	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleColor=" + vehicleColor + ", basePrice=" + basePrice
				+ ", manufactureDate=" + manufactureDate + ", company=" + company + ", isAvailable=" + isAvailable
				+ "]";
	}	
	//getter for date
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	//getter n setter for price
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public String getChasisNo() {
		return chasisNo;
	}

}
