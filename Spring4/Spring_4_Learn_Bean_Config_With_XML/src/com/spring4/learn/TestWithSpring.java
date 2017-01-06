package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.poio.Car;
import com.spring4.learn.poio.HelloWorld;
import com.spring4.learn.poio.Person;

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
		
		// 2, 从 IOC 容器中获取 Bean 实例
		HelloWorld hello = (HelloWorld) cxt.getBean("helloWorld");
		
		// 3, 调用对象方法
		hello.sayHello();
		
		System.out.println();
		HelloWorld hello1 = (HelloWorld) cxt.getBean("helloWorld");
		HelloWorld hello2 = (HelloWorld) cxt.getBean("helloWorld");
		System.out.println(hello);
		System.out.println(hello1);
		System.out.println(hello2);
		
		
		System.out.println();
		Car car = (Car) cxt.getBean("car");
		System.out.println(car);
		
		car = (Car) cxt.getBean("car2");
		System.out.println(car);
		
		System.out.println();
		System.out.println("Bean 之间引用 ：");
		Person person = (Person) cxt.getBean("person");
		System.out.println(person);
		
		System.out.println();
		System.out.println("Bean 之间引用 构造器：");
		person = (Person) cxt.getBean("person2");
		System.out.println(person);
		
		System.out.println();
		System.out.println("Bean 之间引用 null 值赋值：");
		person = (Person) cxt.getBean("person3");
		System.out.println(person);
		
		System.out.println();
		System.out.println("Bean 之间引用 级联属性配置(赋值)：");
		person = (Person) cxt.getBean("person4");
		System.out.println(person);
	}
}
