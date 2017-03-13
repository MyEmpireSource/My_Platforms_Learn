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
 * 					3, 在需要事物管理的实现方法上加上 事物注解(@Transactional)
 * 					   @Transactional
 * 					   public void purchase(String userName, String isbn) {...}
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
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	
	/**
	 * 事物属性
		事物传播行为
		事物隔离级别
		事物对那些异常不回滚
		事物过期时间
	...
	 */
	/**
	 * Spring 事物属性 :
	 * 		1, 事物传播行为
	 * 			
	 */

	@Autowired
	private BookShopDAO bookShopDAO;
	
	// 添加事物注解
	/**
	 * 1, 使用 propagation 指定事物的传播行为, 即当前事物方法被另外一个事物方法调用时, 如何使用事物
	 *    默认取值时 Propagation.REQUIRED, 即使用调用方法的事物
	 *    Propagation.REQUIRES_NEW : 使用事物自己的事物, 调用方法的事物挂起
	 * 
	 * 2, 使用 isolation 指定事物的隔离级别, 最常用的值为 Isolation.READ_COMMITTED(独立提交)
	 * 
	 * 3, 默认情况下, Spring声明事物对所有的运行时异常进行回滚. 
	 *    可以通过对应的属性设置(noRollbackFor, noRollbackForClassName, rollbackFor, rollbackForClassName)
	 * 	     通常情况下取默认值即可
	 * 
	 * 4, 使用readOnly指定事物是否为只读
	 * 	  readOnly=true, 表示这个事务只读取数据但不更新数据, 这样可以帮助数据库引擎优化事务.
	 * 	     若真的是一个只读取数据库记录的方法, 应该设置readOnly=true
	 * 
	 * 5, timeout(值为int, 单位是秒), 指定事物在强制回滚之前, 最多可以占用多少时间, 
	 * 	     若时间超出设定的值而事物还没有执行完毕, 则强制回滚, 防止一个事物对资源占用时间过长, 提高整体运行性能
	 *    timeout = 3, 指物在强制回滚之前, 最多可以占用3秒时间, 3秒后没有执行完, 强制回滚, 释放事物占用的资源
	 */
	@Transactional(
				propagation=Propagation.REQUIRES_NEW, 
				isolation=Isolation.READ_COMMITTED, 
				//noRollbackFor={UserAccountException.class, BookStockException.class}
				readOnly=false, 
				timeout=3
			)
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
