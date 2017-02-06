package com.spring4.learn.poio.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @Package: com.spring4.learn.poio.collections
 * @ClassName: PersonForUtil.java
 *
 * @Description: xml配置学习(applicationContext_collections.xml)
 * 				  配置集合属性, 使用 util schema 里的集合标签定义独立的集合 Bean. (id = "person7, person8")
 * 				 必须在 <beans> 根元素里添加 util schema 定义
 * 
 * 				 使用 p 命名空间后，基于 XML 的配置方式将进一步简化
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月6日 下午4:33:20
 * @UpdateDate: 2017年2月6日 下午4:33:20
 * @Version: V1.0
 */
public class PersonForUtil {
	
	private String name;
	private int age;
	
	private List<String> hobbyList;
	private List<CarForCollection> carList;
	private Map<String, CarForCollection> carMap;
	private Properties properties;
	
	
	public PersonForUtil() {
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

	public List<String> getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}

	public List<CarForCollection> getCarList() {
		return carList;
	}

	public void setCarList(List<CarForCollection> carList) {
		this.carList = carList;
	}

	public Map<String, CarForCollection> getCarMap() {
		return carMap;
	}

	public void setCarMap(Map<String, CarForCollection> carMap) {
		this.carMap = carMap;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "PersonForUtil [name=" + name + ", age=" + age + ", hobbyList=" + hobbyList + ", carList=" + carList
				+ ", carMap=" + carMap + ", properties=" + properties + "]";
	}

}
