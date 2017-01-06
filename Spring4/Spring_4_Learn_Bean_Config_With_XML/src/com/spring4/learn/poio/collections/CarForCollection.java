package com.spring4.learn.poio.collections;

/**
 * 
 * @Package: com.spring4.learn.poio
 * @ClassName: Car.java
 *
 * @Description: xml配置学习(applicationContext.xml)
 * 				  配置集合属性
 * 
 * 				 在 Spring中可以通过一组内置的 xml 标签(例如: <list>, <set> 或 <map>) 来配置集合属性
 * 				 配置 java.util.List 类型的属性, 需要指定 <list>  标签
 * 				 数组的定义和 List 一样, 都使用 <list>
 * 				 配置 java.util.Set 需要使用 <set> 标签
 * 
 * @Company:
 * @Author: 李立  
 * @CreateDate: 2016年7月25日 下午8:21:21
 * @UpdateDate: 2016年7月25日 下午8:21:21
 * @Version: V1.0
 */
public class CarForCollection {
	
	private String brand;
	private String corp;
	private double price;
	private int maxSpeed;
	
	
	public CarForCollection(String brand, String corp, double price) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	

	public CarForCollection(String brand, String corp, int maxSpeed) {
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
