package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.bean.factory.CarForFactory;
import com.spring4.learn.bean.factorybean.CarForFactoryBean;
import com.spring4.learn.bean.instance.factory.CarForInstanceFactory;

public class TestWithSpring_Factory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext_bean_factory.xml");
		
		
		//通过静态工厂方法来配置Bean
		CarForFactory car = (CarForFactory) cxt.getBean("carFactory");
		System.out.println(car);
		
		System.out.println();
		System.out.println();
		
		//实例工厂方法创建 Bean
		CarForInstanceFactory car2 = (CarForInstanceFactory) cxt.getBean("carForInstanceFactory");
		System.out.println(car2);
		
		System.out.println();
		System.out.println();

		
		//实现 FactoryBean 接口在 Spring IOC 容器中配置 Bean
		//单例
		CarForFactoryBean car3Single = (CarForFactoryBean) cxt.getBean("factoryForSingleCar");
		System.out.println(car3Single);
		
		CarForFactoryBean car4Single = (CarForFactoryBean) cxt.getBean("factoryForSingleCar");
		System.out.println(car4Single);
		System.out.println(car3Single.equals(car4Single));
		car3Single.setPrice(350);
		System.out.println(car3Single);
		System.out.println(car4Single);
		
		System.out.println();
		System.out.println();
		//非单例
		CarForFactoryBean car1NotSingle = (CarForFactoryBean) cxt.getBean("factoryForNotSingleCar");
		System.out.println(car1NotSingle);
		
		CarForFactoryBean car2NotSingle = (CarForFactoryBean) cxt.getBean("factoryForNotSingleCar");
		System.out.println(car2NotSingle);
		System.out.println(car2NotSingle.equals(car1NotSingle));
		car1NotSingle.setPrice(350);
		System.out.println(car1NotSingle);
		System.out.println(car2NotSingle);
	}

}
 