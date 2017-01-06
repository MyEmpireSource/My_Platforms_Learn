package com.spring4.learn.poio.collections;

import java.util.List;

/**
 * 
 * @Package: com.spring4.learn.poio
 * @ClassName: Person.java
 *
 * @Description: xml配置学习(applicationContext.xml)
 * 				  配置集合属性 (id = "person5")
 * 
 * 				 在 Spring中可以通过一组内置的 xml 标签(例如: <list>, <set> 或 <map>) 来配置集合属性
 * 				 配置 java.util.List 类型的属性, 需要指定 <list>  标签
 * 				 数组的定义和 List 一样, 都使用 <list>
 * 				 配置 java.util.Set 需要使用 <set> 标签
 * 
 * @Company:
 * @Author: 李立  
 * @CreateDate: 2016年7月25日 下午8:25:43
 * @UpdateDate: 2016年7月25日 下午8:25:43
 * @Version: V1.0
 */
public class PersonForCollection {
	
	private String name;
	private int age;
	
	private List<CarForCollection> carList;
	
	public PersonForCollection() {}

	public PersonForCollection(String name, int age, List<CarForCollection> carList) {
		this.name = name;
		this.age = age;
		this.carList = carList;
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

	public List<CarForCollection> getCarList() {
		return carList;
	}

	public void setCarList(List<CarForCollection> carList) {
		this.carList = carList;
	}

	@Override
	public String toString() {
		return "PersonForCollection [name=" + name + ", age=" + age + ", carList=" + carList + "]";
	}
}
