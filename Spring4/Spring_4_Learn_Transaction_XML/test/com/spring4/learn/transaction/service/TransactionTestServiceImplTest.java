package com.spring4.learn.transaction.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"Service-Test-context.xml"})
public class TransactionTestServiceImplTest {

	@Autowired
	private TransactionTestService transactionTestService;
	
	@Test
	public void testMyTransactionTest() {
		
		this.transactionTestService.myTransactionTest();
		
	}

}
