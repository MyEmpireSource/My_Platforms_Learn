package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.generic.di.bean.User;
import com.spring4.learn.generic.di.bean.UserService;

public class TestWithSpring_GenericDI {
	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext_beans_generic_di.xml");
		
		UserService userService = (UserService) cxt.getBean("userService");
		userService.add(new User("GG", 15));
		
	}
}