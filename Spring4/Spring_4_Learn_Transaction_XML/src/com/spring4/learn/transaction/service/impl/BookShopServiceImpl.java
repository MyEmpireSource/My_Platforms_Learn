package com.spring4.learn.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring4.learn.exception.BookStockException;
import com.spring4.learn.exception.UserAccountException;
import com.spring4.learn.transaction.dao.BookShopDAO;
import com.spring4.learn.transaction.service.BookShopService;

/**
 * 
 * @Package: com.spring4.learn.transaction.service.impl
 * @ClassName: BookShopServiceImpl.java
 *
 * @Description: Spring 4 注解添加事物管理支持
 * 				  步骤: 
 * 					1, 在配置文件(如applicationContext.xml)中 配置事物管理器 
 * 					   <bean id="jdbcDataSourceTransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
 * 							<property name="dataSource" ref="dataSource"></property>
 * 					   </bean>
 * 					
 * 					2, 在配置文件(如applicationContext.xml)中 配置 配置事物管理驱动 启用事物注解
 * 					   <tx:annotation-driven transaction-manager="jdbcDataSourceTransactionManager"/>
 * 					   transaction-manager 值为 事物管理器 Id
 * 					
 * 					
 * 
 * 
 * 
 * 				
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年3月7日 下午4:31:20
 * @UpdateDate: 2017年3月7日 下午4:31:20
 * @Version: V1.0
 */
public class BookShopServiceImpl implements BookShopService {
	
	private BookShopDAO bookShopDAO;
	
	public void setBookShopDAO(BookShopDAO bookShopDAO) {
		this.bookShopDAO = bookShopDAO;
	}
	
	@Override
	public void purchase(String userName, String isbn) {
		// TODO Auto-generated method stub
		// 1, 读取书的单价
		float price = this.bookShopDAO.findBookPriceByIsbn(isbn);
		
		System.out.println("before operate, book [" + isbn + "] stock : " + this.bookShopDAO.findBookStockByIsbn(isbn));
		
		// 2, 更新书的库存
		this.bookShopDAO.updateBookStock(isbn);
		
		System.out.println("after operate, book [" + isbn + "] stock : " + this.bookShopDAO.findBookStockByIsbn(isbn));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3, 更新用户的余额
		this.bookShopDAO.updateUserAccount(userName, price);

	}

}
