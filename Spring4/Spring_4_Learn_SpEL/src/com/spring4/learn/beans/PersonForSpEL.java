package com.spring4.learn.beans;

/**
 * 
 * @Package: com.spring4.learn.poio.autowire
 * @ClassName: PersonForAutowire.java
 *
 * @Description: SpEL配置学习(applicationContexr.xml)
 * 
 * 				 Spring 表达式语言（简称SpEL）：是一个支持运行时查询和操作对象图的强大的表达式语言。
 * 				   语法类似于 EL：SpEL 使用 #{…} 作为定界符，所有在大框号中的字符都将被认为是 SpEL
 * 				 SpEL 为 bean 的属性进行动态赋值提供了便利
 * 				   通过 SpEL 可以实现：
 * 					通过 bean 的 id 对 bean 进行引用 
 * 					调用方法以及引用对象中的属性 
 * 					计算表达式的值 
 * 					正则表达式的匹配
 * 				  
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月7日 下午2:11:23
 * @UpdateDate: 2017年2月7日 下午2:11:23
 * @Version: V1.0
 */
public class PersonForSpEL {
	
	private String name;
	
	private CarForSpEL carForSpELOfMy;
	
	//引用Address bean 的city属性
	private String city;
	//根据Car的price确定info
	//car.price >= 300000 : 中产
	//car.price < 300000 : 普通
	private String info;
	

	public PersonForSpEL() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CarForSpEL getCarForSpELOfMy() {
		return carForSpELOfMy;
	}

	public void setCarForSpELOfMy(CarForSpEL carForSpELOfMy) {
		this.carForSpELOfMy = carForSpELOfMy;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "PersonForSpEL [name=" + name + ", carForSpELOfMy=" + carForSpELOfMy + ", city=" + city + ", info=" + info + "]";
	}
	
	
}
