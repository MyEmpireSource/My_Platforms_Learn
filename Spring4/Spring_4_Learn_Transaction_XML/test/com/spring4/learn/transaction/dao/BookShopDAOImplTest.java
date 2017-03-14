package com.spring4.learn.transaction.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"Test-context.xml"})
@ContextConfiguration(locations={"classpath:Test-context.xml"})
public class BookShopDAOImplTest {
	
	@Autowired
	private BookShopDAO bookShopDAO;
	

	@Test
	public void testFindBookPriceByIsbn() {
		//fail("Not yet implemented");
		System.out.println(this.bookShopDAO.findBookPriceByIsbn("1001"));
	}

	@Test
	public void testUpdateBookStock() {
		this.bookShopDAO.updateBookStock("1001");
	}

	@Test
	public void testUpdateUserAccount() {
		this.bookShopDAO.updateUserAccount("AA", 200);
	}
	
	@Test
	public void testFindBookStockByIsbn() {
		System.out.println(this.bookShopDAO.findBookStockByIsbn("1001"));
	}
	
	@Test
	public void testFindAccountBalanceByUserName() {
		System.out.println(this.bookShopDAO.findAccountBalanceByUserName("AA"));
	}

}
