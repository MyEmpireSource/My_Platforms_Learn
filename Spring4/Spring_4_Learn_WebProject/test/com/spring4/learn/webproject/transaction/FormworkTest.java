package com.spring4.learn.webproject.transaction;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.webproject.transaction.controller.LoginAction;
import com.spring4.learn.webproject.transaction.service.LoginService;

public class FormworkTest {
	
	private ApplicationContext ctx = null;
	
	{
		//ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx = new ClassPathXmlApplicationContext("springApplication-servlet.xml");
	}
	
	@Test
	public void testFormwork() throws IOException {
		/*
		LoginService loginService = (LoginService) ctx.getBean("loginService");
		loginService.checkAccount("", "");
		*/
		
		System.out.println("******************************");
		LoginAction loginAction = ctx.getBean(LoginAction.class);
		loginAction.loginAction(null, null);
	}
	
}
