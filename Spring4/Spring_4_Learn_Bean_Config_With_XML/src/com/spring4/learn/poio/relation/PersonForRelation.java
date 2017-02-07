package com.spring4.learn.poio.relation;

/**
 * 
 * @Package: com.spring4.learn.poio.relation
 * @ClassName: PersonForRelation.java
 *
 * @Description: xml配置学习(applicationContext_bean_relation.xml)
 * 				 Spring Bean之间的配置关系 配置
 * 				 Spring Bean之间配置关系为 继承, 依赖
 * 				  是指Spring配置上的继承与依赖, 非面向对象语言的继承依赖关系 
 * 
 * 				 Bean的配置继承: 使用Bean的 parent 属性指定继承哪个 Bean的配置
 * 				  子 Bean 从父 Bean 中继承配置, 包括 Bean 的属性配置
 * 				  子 Bean 也可以覆盖从父 Bean 继承过来的配置
 * 				  父 Bean 可以作为配置模板, 也可以作为 Bean 实例. 
 * 					若只想把父 Bean 作为模板, 可以设置 <bean> 的 abstract 属性为 true, 这样 Spring 将不会实例化这个 Bean
 * 					可以忽略父 Bean 的 class 属性, 让子 Bean 指定自己的类, 而共享相同的属性配置. 但此时 abstract 必须设为 true
 * 				 并不是 <bean> 元素里的所有属性都会被继承. 比如: autowire, abstract 
 * 		
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月7日 下午2:17:32
 * @UpdateDate: 2017年2月7日 下午2:17:32
 * @Version: V1.0
 */
public class PersonForRelation {
	
	private String name;
	
	private AddressForRelation address;
	
	private CarForRelation car;

	public PersonForRelation() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressForRelation getAddress() {
		return address;
	}

	public void setAddress(AddressForRelation address) {
		this.address = address;
	}

	public CarForRelation getCar() {
		return car;
	}

	public void setCar(CarForRelation car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "PersonForRelation [name=" + name + ", address=" + address + ", car=" + car + "]";
	}
	
}
