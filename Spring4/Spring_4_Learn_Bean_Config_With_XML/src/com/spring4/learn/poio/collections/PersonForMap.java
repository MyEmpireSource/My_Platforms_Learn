package com.spring4.learn.poio.collections;

import java.util.Map;

/**
 * 
 * @Package: com.spring4.learn.poio.collections
 * @ClassName: PersonForMap.java
 *
 * @Description: xml配置学习(applicationContext_collections.xml)
 * 				  配置集合属性 (id = "person6")
 * 
 * 				 Java.util.Map 通过 <map> 标签定义, 
 * 				 <map> 标签里可以使用多个 <entry> 作为子标签. 每个条目包含一个键和一个值. 
 * 				  必须在 <key> 标签里定义键, 因为键和值的类型没有限制, 所以可以自由地为它们指定 <value>, <ref>, <bean> 或 <null> 元素. 
 * 				  可以将 Map 的键和值作为 <entry> 的属性定义: 简单常量使用 key 和 value 来定义; Bean 引用通过 key-ref 和 value-ref 属性定义
 * 				
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月6日 下午3:20:08
 * @UpdateDate: 2017年2月6日 下午3:20:08
 * @Version: V1.0
 */
public class PersonForMap {
	
	private String name;
	private int age;
	
	private Map<String, CarForCollection> carMap;

	public PersonForMap() {
	}

	public PersonForMap(String name, int age, Map<String, CarForCollection> carMap) {
		super();
		this.name = name;
		this.age = age;
		this.carMap = carMap;
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

	public Map<String, CarForCollection> getCarMap() {
		return carMap;
	}

	public void setCarMap(Map<String, CarForCollection> carMap) {
		this.carMap = carMap;
	}

	@Override
	public String toString() {
		return "PersonForMap [name=" + name + ", age=" + age + ", carMap=" + carMap + "]";
	}
	
	
	
}
