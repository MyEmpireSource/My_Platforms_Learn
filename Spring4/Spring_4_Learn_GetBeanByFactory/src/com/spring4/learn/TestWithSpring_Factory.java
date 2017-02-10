package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.bean.factory.CarForFactory;
import com.spring4.learn.bean.instance.factory.CarForInstanceFactory;

public class TestWithSpring_Factory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext_bean_factory.xml");
		
		CarForFactory car = (CarForFactory) cxt.getBean("carFactory");
		System.out.println(car);
		
		
		CarForInstanceFactory car2 = (CarForInstanceFactory) cxt.getBean("carForInstanceFactory");
		System.out.println(car2);
		
	}

}
