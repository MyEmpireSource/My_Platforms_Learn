package com.spring4.learn.webproject.util.exception;

public class WarnException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WarnException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WarnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public WarnException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public WarnException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WarnException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
