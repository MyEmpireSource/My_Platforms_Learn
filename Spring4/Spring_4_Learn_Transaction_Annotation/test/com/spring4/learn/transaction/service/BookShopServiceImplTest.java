package com.spring4.learn.transaction.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"Service-Test-context.xml"})
public class BookShopServiceImplTest {

	@Autowired
	private BookShopService bookShopService;
	
	@Test
	public void testPurchase() {
		//fail("Not yet implemented");
		this.bookShopService.purchase("AA", "1001");
	}

}
