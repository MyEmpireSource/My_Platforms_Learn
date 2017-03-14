package com.spring4.learn.transaction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring4.learn.transaction.service.BookShopService;
import com.spring4.learn.transaction.service.Cashier;

/**
 * 
 * @Package: com.spring4.learn.transaction.service.impl
 * @ClassName: CashierImpl.java
 *
 * @Description: 结账
 * 				  事物传递性测试
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年3月8日 下午4:09:11
 * @UpdateDate: 2017年3月8日 下午4:09:11
 * @Version: V1.0
 */
public class CashierImpl implements Cashier {

	private BookShopService bookShopService;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	@Override
	public void checkout(String userName, List<String> isbnList) {
		// TODO Auto-generated method stub

		for (String isbn : isbnList) {
			/**
			 * 当 bookShopService.purchase() 方法事物的传递属性为 Propagation.REQUIRES_NEW 时
			 * 只要满足的就会被提交事物, 不满足才回滚
			 * 即 买两本书, 第一本满足条件及更新数据, 第二本不满足只回滚第二本的
			 */
			this.bookShopService.purchase(userName, isbn);
		}
		
	}

}
