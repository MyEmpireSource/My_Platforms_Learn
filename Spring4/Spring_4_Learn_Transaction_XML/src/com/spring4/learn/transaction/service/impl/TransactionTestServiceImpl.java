package com.spring4.learn.transaction.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring4.learn.transaction.dao.AccountDAO;
import com.spring4.learn.transaction.service.BookShopService;
import com.spring4.learn.transaction.service.TransactionTestService;

public class TransactionTestServiceImpl implements TransactionTestService {

	private AccountDAO accountDAO;
	
	private BookShopService bookShopService;
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	@Override
	public void myTransactionTest() {
		// TODO Auto-generated method stub
		
		for (int i = 0 ; i < 5; i++) {
			this.accountDAO.addAccount("AA_" + i, 0);
		}
		
		List<String> isbnList = Arrays.asList("1001", "1002", "1001", "1002");
		String userName = "AA";
		
		int i = 0;
		for (String isbn : isbnList) {
			/**
			 * 当 bookShopService.purchase() 方法事物的传递属性为 Propagation.REQUIRES_NEW 时
			 * 只要满足的就会被提交事物, 不满足才回滚
			 * 即 买两本书, 第一本满足条件及更新数据, 第二本不满足只回滚第二本的
			 */
			this.bookShopService.purchase(userName, isbn);
			
			i++;
			if (i == 3) {
				// 买书的事物提交 
				// 添加人员的事物回滚
				throw new RuntimeException("测试 ^_^ ... ...");
			}
		}

		
	}

}
