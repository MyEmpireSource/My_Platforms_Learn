package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.aop.service.ArithmeticCalculator;

public class TestWithSpring_AOP_XML {

	public static void main(String[] args) {
		// 1, 创建 Spring 的IOC容器
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2, 从IOC容器中获取Bean的实例
		
		ArithmeticCalculator cal = (ArithmeticCalculator) cxt.getBean("arithmeticCalculator");
		
		// 3, 使用Bean
		cal.add(1, 3);
		System.out.println();
		cal.div(6, 2);
		System.out.println();
		cal.div(6, -1);
		
		System.out.println();
		cal.div(6, 0);
	}
}
