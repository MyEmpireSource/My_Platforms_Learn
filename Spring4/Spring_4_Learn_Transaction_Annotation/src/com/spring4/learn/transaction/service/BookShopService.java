package com.spring4.learn.transaction.service;

public interface BookShopService {
	
	/**
	 * 
	 * @Title: purchase
	 * @Description: 买书服务, 书的库存减一, 用户账户的余额减去书的价格
	 * 
	 * @Params:
	 *   @param userName
	 *   @param isbn
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年3月7日 下午3:01:34
	 * @ChangeDate: 2017年3月7日 下午3:01:34
	 * @Author: ZCX
	 */
	public void purchase(String userName, String isbn);
	
}
