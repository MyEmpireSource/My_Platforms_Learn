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
@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	
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
	@Transactional(propagation=Propagation.REQUIRES_NEW)
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
