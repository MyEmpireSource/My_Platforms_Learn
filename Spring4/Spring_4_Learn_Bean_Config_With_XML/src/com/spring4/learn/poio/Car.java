package com.spring4.learn.poio;

/**
 * 
 * @Package: com.spring4.learn.poio
 * @ClassName: Car.java
 *
 * @Description: xml配置学习(applicationContext.xml, applicationContext_bean_references.xml)
 * 				   学习 通过构造方法来配置Bean 的属性(id="car" | id="car2" )
 * 
 * @Company:
 * @Author: 李立  
 * @CreateDate: 2016年7月25日 下午8:21:21
 * @UpdateDate: 2016年7月25日 下午8:21:21
 * @Version: V1.0
 */
public class Car {
	
	private String brand;
	private String corp;
	private double price;
	private int maxSpeed;
	
	
	public Car(String brand, String corp, double price) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	

	public Car(String brand, String corp, int maxSpeed) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.maxSpeed = maxSpeed;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public void setCorp(String corp) {
		this.corp = corp;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	@Override
	public String toString() {
		return "Car [brand=" + brand + ", corp=" + corp + ", price=" + price + ", maxSpeed=" + maxSpeed + "]";
	}
	
}
