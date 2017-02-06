package com.spring4.learn.poio.collections;

import java.util.List;

/**
 * 
 * @Package: com.spring4.learn.poio
 * @ClassName: PersonForCollection.java
 *
 * @Description: xml配置学习(applicationContext_collections.xml)
 * 				  配置Map集合属性 (id = "person6")
 * 
 * 				 
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
	
	private List<String> hobbyList; //爱好
	
	public PersonForCollection() {}

	public PersonForCollection(String name, int age, List<CarForCollection> carList, List<String> hobbyList) {
		this.name = name;
		this.age = age;
		this.carList = carList;
		this.hobbyList = hobbyList;
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

	public List<String> getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}

	@Override
	public String toString() {
		return "PersonForCollection [name=" + name + ", age=" + age + ", carList=" + carList + ", hobbyList="
				+ hobbyList + "]";
	}
}
