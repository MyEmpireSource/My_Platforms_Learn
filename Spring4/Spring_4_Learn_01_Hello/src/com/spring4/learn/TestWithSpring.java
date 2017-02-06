package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestWithSpring {
	
	public static void main(String[] args) {
		/* 非Spring 管理
		//创建 HelloWorld 的一个对象
		HelloWorld hello = new HelloWorld();
		//为 name 属性赋值
		hello.setName2("Test Count");
		//调用对象方法
		hello.sayHello();
		*/
		
		// 1, 创建Spring IOC 容器
		//配置文件在classPath下 (src文件夹下)
		//ApplicationContext 代表 IOC 容器
		//ClassPathXmlApplicationContext: 是ApplicationContext接口实现类 ， 该实现类从类路径下加载配置文件
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2, 从 IOC 容器中获取 Bean 实例(利用id 对应到IOC容器中的Bean)
		HelloWorld hello = (HelloWorld) cxt.getBean("helloWorld");
		
		// 3, 调用对象方法
		hello.sayHello();
		
		//--------------------------------
		//利用类型返回 IOC 容器中的对象 ， 但要求IOC容器中只有一个该类型的Bean
		//要求在配置文件中， HelloWorld.class类型的只有一个配置
		//HelloWorld hello3 = cxt.getBean(HelloWorld.class);
	}
}
