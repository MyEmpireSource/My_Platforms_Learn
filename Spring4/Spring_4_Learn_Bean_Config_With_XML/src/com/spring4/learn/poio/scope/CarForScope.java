package com.spring4.learn.poio.scope;

/**
 * 
 * @Package: com.spring4.learn.poio.scope
 * @ClassName: CarForScope.java
 *
 * @Description: xml配置学习(applicationContext_bean_scope.xml)
 * 				 Bean的作用域配置
 *                  使用 <bean> 的scope属性来配置Bean的作用域 
 *                  scope="singleton" 是默认值(单例的), 容器初始化是创建Bean实例, 在整个生命周期内只创建这一个Bean, 单例的 
 *                  scope="prototype" 原型的, 容器初始化时不创建Bean的实例, 而在每次请求时都创建一个新的Bean实例, 并返回
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月7日 下午4:15:36
 * @UpdateDate: 2017年2月7日 下午4:15:36
 * @Version: V1.0
 */
public class CarForScope {
	
	private String brand;
	private String corp;
	private double price;
	private int maxSpeed;
	
	public CarForScope() {
		System.out.println("CarForScope's Constructor ... ...");
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
		return "CarForScope [brand=" + brand + ", corp=" + corp + ", price=" + price + ", maxSpeed=" + maxSpeed + "]";
	}
	
}
