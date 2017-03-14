package com.spring4.learn.exception;

/**
 * 
 * @Package: com.spring4.learn.exception
 * @ClassName: UserAccountException.java
 *
 * @Description: 账户异常, 账户余额 <= 购买商品价格时, 抛出该异常
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年3月7日 上午11:46:01
 * @UpdateDate: 2017年3月7日 上午11:46:01
 * @Version: V1.0
 */
public class UserAccountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public UserAccountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
