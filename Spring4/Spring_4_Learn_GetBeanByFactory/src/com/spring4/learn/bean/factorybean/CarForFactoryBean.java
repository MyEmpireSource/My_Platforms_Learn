package com.spring4.learn.bean.factorybean;

public class CarForFactoryBean {
	
	private String brand;
	private String corp;
	private double price;
	private int maxSpeed;
	
	public CarForFactoryBean() {
	}
	
	public CarForFactoryBean(String brand, String corp, double price, int maxSpeed) {
		
		System.out.println("CarForFactoryBean's Constructor ... ...");
		
		this.brand = brand;
		this.corp = corp;
		this.price = price;
		this.maxSpeed = maxSpeed;
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

	@Override
	public String toString() {
		return "CarForFactoryBean [brand=" + brand + ", corp=" + corp + ", price=" + price + ", maxSpeed=" + maxSpeed
				+ "]";
	}
	
}
