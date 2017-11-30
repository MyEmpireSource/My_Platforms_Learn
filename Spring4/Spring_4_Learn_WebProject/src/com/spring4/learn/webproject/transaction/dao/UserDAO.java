package com.spring4.learn.webproject.transaction.dao;

import com.spring4.learn.webproject.entity.User;

public interface UserDAO {
	
	public String testDao(String account, String passwd);
	
	/**
	 * 
	 * @Title: userLogin
	 * @Description: 通过账号和密码查找用户
	 * 
	 * @Params:
	 *   @param account
	 *   @return
	 *
	 * @Return: User
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年4月1日 下午3:15:28
	 * @ChangeDate: 2017年4月1日 下午3:15:28
	 * @Author: ZCX
	 */
	public User queryUserByAccount(String account);
	
}
