package com.spring4.learn.transaction.dao;

public interface BookShopDAO {

	/**
	 * 
	 * @Title: findBookPriceByIsbn
	 * @Description: 根据书号获取书的单价
	 * 
	 * @Params:
	 *   @param isbn
	 *   @return
	 *
	 * @Return: float
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年3月7日 上午10:35:26
	 * @ChangeDate: 2017年3月7日 上午10:35:26
	 * @Author: ZCX
	 */
	public float findBookPriceByIsbn(String isbn);
	
	/**
	 * 
	 * @Title: updateBookStock
	 * @Description: 更新书的库存, 使书号对应的库存 减 1
	 * 
	 * @Params:
	 *   @param isbn
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年3月7日 上午10:35:55
	 * @ChangeDate: 2017年3月7日 上午10:35:55
	 * @Author: ZCX
	 */
	public void updateBookStock(String isbn);
	
	/**
	 * 
	 * @Title: updateUserAccount
	 * @Description: 更新账户余额, 使userName的balance 减 price
	 * 
	 * @Params:
	 *   @param userName
	 *   @param blance
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年3月7日 上午10:36:43
	 * @ChangeDate: 2017年3月7日 上午10:36:43
	 * @Author: ZCX
	 */
	public void updateUserAccount(String userName, float price);
	
	/**
	 * 
	 * @Title: findBookStockByIsbn
	 * @Description: 获取书的库存
	 * 
	 * @Params:
	 *   @param isbn
	 *   @return
	 *
	 * @Return: int
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年3月7日 下午2:40:05
	 * @ChangeDate: 2017年3月7日 下午2:40:05
	 * @Author: ZCX
	 */
	public int findBookStockByIsbn(String isbn);
	
	/**
	 * 
	 * @Title: findAccountBalanceByUserName
	 * @Description: 获取用户的余额
	 * 
	 * @Params:
	 *   @param userName
	 *   @return
	 *
	 * @Return: float
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年3月7日 下午2:40:17
	 * @ChangeDate: 2017年3月7日 下午2:40:17
	 * @Author: ZCX
	 */
	public float findAccountBalanceByUserName(String userName);
}
