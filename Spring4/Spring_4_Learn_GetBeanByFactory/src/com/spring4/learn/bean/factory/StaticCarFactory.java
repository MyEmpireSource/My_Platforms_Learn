package com.spring4.learn.bean.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Package: com.spring4.learn.bean.factory
 * @ClassName: StaticCarFactory.java
 *
 * @Description: 通过静态工厂方法来配置Bean, 注意不是配置静态工厂方法实例, 
 * 				   而是配置Bean实例(applicationContet_bean_factory.xml)
 * 				 (id = ["carFactory"])				 
 * 
 * 				  静态工厂方法: 直接调用某一个类的静态方法就可以返回Bean的实例
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月9日 下午4:12:46
 * @UpdateDate: 2017年2月9日 下午4:12:46
 * @Version: V1.0
 */
public class StaticCarFactory {
	
	private static Map<String, CarForFactory> carsMap = new HashMap<String, CarForFactory>();
	
	static {
		carsMap.put("Audi", new CarForFactory("Audi", "ShangHai", 200053, 265));
		carsMap.put("Ford", new CarForFactory("Ford", "ShangHai", 100053, 200));
	}
	
	/**
	 * 
	 * @Title: getCar
	 * @Description: 静态工厂方法: 直接调用某一个类的静态方法就可以返回Bean的实例
	 * 
	 * @Params:
	 *   @param name
	 *   @return
	 *
	 * @Return: CarForFactory
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月9日 下午4:19:27
	 * @ChangeDate: 2017年2月9日 下午4:19:27
	 * @Author: ZCX
	 */
	public static CarForFactory getCar(String name) {
		return StaticCarFactory.carsMap.get(name);
	}
}
