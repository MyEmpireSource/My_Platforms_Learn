package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.aop.service.ArithmeticCalculator;
import com.spring4.learn.aop.service.impl.ArithmeticCalculatorImpl;

/**
 * 
 * @Package: com.spring4.learn
 * @ClassName: TestWithSpring_AOP.java
 *
 * @Description: 通过 Spring 基于 AspectJ 注解或基于 XML 配置的 AOP 来实现需求
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月24日 下午2:55:44
 * @UpdateDate: 2017年2月24日 下午2:55:44
 * @Version: V1.0
 */
public class TestWithSpring_AOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		
	}

}
