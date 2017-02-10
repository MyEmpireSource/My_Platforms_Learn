package com.spring4.learn.bean.factory;

/**
 * 
 * @Package: com.spring4.learn.bean.factory
 * @ClassName: CarForFactory.java
 *
 * @Description: 通过静态工厂方法来配置Bean, 注意不是配置静态工厂方法实例, 
 * 				   而是配置Bean实例(applicationContet_bean_factory.xml)
 * 				 (id = ["carFactory"])				 
 * 
 * 				  静态工厂方法: 直接调用某一个类的静态方法就可以返回Bean的实例
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月10日 下午2:07:46
 * @UpdateDate: 2017年2月10日 下午2:07:46
 * @Version: V1.0
 */
public class CarForFactory {
	
	private String brand;
	private String corp;
	private double price;
	private int maxSpeed;
	
	public CarForFactory() {
	}
	
	public CarForFactory(String brand, String corp, double price, int maxSpeed) {
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
		return "CarForFactory [brand=" + brand + ", corp=" + corp + ", price=" + price + ", maxSpeed=" + maxSpeed
				+ "]";
	}
	
}
