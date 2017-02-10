package com.spring4.learn.bean.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 
 * @Package: com.spring4.learn.bean.factorybean
 * @ClassName: FactoryBeanForSingleCar.java
 *
 * @Description: 实现 FactoryBean 接口在 Spring IOC 容器中配置 Bean(applicationContet_bean_factory.xml)
 * 				 (id=["factoryForSingleCar", "factoryForNotSingleCar"])				 
 * 
 * 				  自定义的FactoryBean需要实现 org.springframework.beans.factory.FactoryBean
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月10日 下午3:22:43
 * @UpdateDate: 2017年2月10日 下午3:22:43
 * @Version: V1.0
 */
public class FactoryBeanForSingleCar implements FactoryBean<CarForFactoryBean> {

	private String brand;
	
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * 返回Bean的对象
	 */
	@Override
	public CarForFactoryBean getObject() throws Exception {
		// TODO Auto-generated method stub
		//return null;
		System.out.println("FactoryBeanForSingleCar.getObject ... ... ");;
		return new CarForFactoryBean(this.brand, "ShangHai", 305212, 280);
	}

	/**
	 * 返回Bean的类型
	 */
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		//return null;
		return CarForFactoryBean.class;
	}

	/**
	 * 返回的Bean是不是单实例,
	 * 返回 true 则通过该FactoryBean获取的Bean是单例的(只创建一个)
	 * 返回 false 则通过该FactoryBean获取的Bean不是单例的(每次都创建)
	 */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
