package com.spring4.learn.exception;

/**
 * 
 * @Package: com.spring4.learn.exception
 * @ClassName: BookStockException.java
 *
 * @Description: 书库存异常, 当书库存 <= 0时, 再买书就抛出该异常
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年3月7日 上午11:43:11
 * @UpdateDate: 2017年3月7日 上午11:43:11
 * @Version: V1.0
 */
public class BookStockException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookStockException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookStockException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public BookStockException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public BookStockException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BookStockException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
