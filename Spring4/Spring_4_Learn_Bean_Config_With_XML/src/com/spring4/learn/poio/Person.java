package com.spring4.learn.poio;

/**
 * 
 * @Package: com.spring4.learn.poio
 * @ClassName: Person.java
 *
 * @Description: xml配置学习(applicationContext.xml, applicationContext_bean_references.xml)
 * 				 学习Bean之间引用的配置(id="person" | id="person2" | id="person3" | id="person4")
 * 
 * @Company:
 * @Author: 李立  
 * @CreateDate: 2016年7月25日 下午8:25:43
 * @UpdateDate: 2016年7月25日 下午8:25:43
 * @Version: V1.0
 */
public class Person {
	
	private String name;
	private int age;
	
	private Car car;
	

	public Person() {}

	public Person(String name, int age, Car car) {
		this.name = name;
		this.age = age;
		this.car = car;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
}
