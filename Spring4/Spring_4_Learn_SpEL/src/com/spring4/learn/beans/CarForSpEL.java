package com.spring4.learn.beans;

public class CarForSpEL {
	
	private String brand;
	private String corp;
	private double price;
	private int maxSpeed;
	
	//轮胎周长
	private double tyrePerimeter;
	
	public CarForSpEL() {
	}

	public CarForSpEL(String brand, String corp, double price, int maxSpeed, double tyrePerimeter) {
		this.brand = brand;
		this.corp = corp;
		this.price = price;
		this.maxSpeed = maxSpeed;
		this.tyrePerimeter = tyrePerimeter;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	

	public double getTyrePerimeter() {
		return tyrePerimeter;
	}

	public void setTyrePerimeter(double tyrePerimeter) {
		this.tyrePerimeter = tyrePerimeter;
	}

	@Override
	public String toString() {
		return "CarForSpEL [brand=" + brand + ", corp=" + corp + ", price=" + price + ", maxSpeed=" + maxSpeed
				+ ", tyrePerimeter=" + tyrePerimeter + "]";
	}

	
	
}
