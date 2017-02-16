package com.spring4.learn.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.annotation.bean.TestObject;
import com.spring4.learn.annotation.controller.UserController;
import com.spring4.learn.annotation.repository.UserRepository;
import com.spring4.learn.annotation.service.UserService;

public class TestWithSpring_Annonation {
	
	public static void main(String[] args) {
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext_annotation.xml");
/* 		
		TestObject to = (TestObject) cxt.getBean("testObject");
		System.out.println(to);
		
		UserController userController = (UserController) cxt.getBean("userController");
		System.out.println(userController);
		
		UserService userService = (UserService) cxt.getBean("userService");
		System.out.println(userService);
		
		UserRepository userRepository = (UserRepository) cxt.getBean("userRepository");
		System.out.println(userRepository);
*/
		UserController userController = (UserController) cxt.getBean("userController");
		userController.execute();
	}
	
}
