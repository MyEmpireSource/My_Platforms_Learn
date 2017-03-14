package com.spring4.learn.transaction.service;

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CashierImplTest {
	
	private ApplicationContext ctx = null;
	private Cashier cashier = null;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		cashier = (Cashier) ctx.getBean("cashier");
	}
	
	@Test
	public void testCheckout() {
		//System.out.println("sdfsdf");;
		cashier.checkout("AA", Arrays.asList("1001", "1002", "1001", "1002"));
	}

}
