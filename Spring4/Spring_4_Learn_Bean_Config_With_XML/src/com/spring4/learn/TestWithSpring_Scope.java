package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.poio.scope.CarForScope;

public class TestWithSpring_Scope {

	public static void main(String[] args) {
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext_bean_scope.xml");
		
		
		/**
		 * 默认配置, Spring IOC容器中Bean时单实例的 (scope="singleton"), 
		 * (IOC容器中只创建一个Bean的实例，多次请求返回的都是同一个), 在IOC容器创建时被初始化
		 */
		CarForScope car1 = (CarForScope) cxt.getBean("car_scope");
		System.out.println(car1.toString());
		
		CarForScope car2 = (CarForScope) cxt.getBean("car_scope");
		System.out.println(car2.toString());
		
		//car1和car2是同一个对象
		System.out.println(car1.equals(car2));
		
		car2.setBrand("Audi^_^");
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		
		System.out.println();
		System.out.println();
		
		
		/**
		 * 作用域时原型的(scope="prototype" 原型的)
		 * 容器初始化时不创建Bean的实例, 而在每次请求时都创建一个新的Bean实例, 并返回)
		 */
		CarForScope car3 = (CarForScope) cxt.getBean("car_scope_prototype");
		CarForScope car4 = (CarForScope) cxt.getBean("car_scope_prototype");
		System.out.println(car3.equals(car4));
		
		car3.setBrand("DaZhong^_^");
		System.out.println(car3.toString());
		System.out.println(car4.toString());
		
	}
	
}
