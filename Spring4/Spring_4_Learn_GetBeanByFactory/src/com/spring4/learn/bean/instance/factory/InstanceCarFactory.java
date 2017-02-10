package com.spring4.learn.bean.instance.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Package: com.spring4.learn.bean.instance.factory
 * @ClassName: InstanceCarFactory.java
 *
 * @Description: 实例工厂方法创建 Bean(applicationContet_bean_factory.xml)
 * 				 (id=["instanceCarFactory", "carForInstanceFactory"])
 * 				   实例工厂方法: 实例工厂的方法, 即先需要创建工厂本身, 再调用工厂的实例方法来返回Bean的实例
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月10日 下午1:52:46
 * @UpdateDate: 2017年2月10日 下午1:52:46
 * @Version: V1.0
 */
public class InstanceCarFactory {
	private Map<String, CarForInstanceFactory> carsMap = null;
	
	public InstanceCarFactory() {
		this.carsMap = new HashMap<String, CarForInstanceFactory>();
		
		carsMap.put("AUDI", new CarForInstanceFactory("Audi", "ShangHai", 300053, 265));
		carsMap.put("FORD", new CarForInstanceFactory("Ford", "ShangHai", 200053, 200));
	}
	
	public CarForInstanceFactory getCar(String brand){
		System.out.println(brand);
		return this.carsMap.get(brand);
	}
}
