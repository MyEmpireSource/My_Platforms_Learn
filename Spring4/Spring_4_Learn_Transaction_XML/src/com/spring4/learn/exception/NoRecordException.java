package com.spring4.learn.exception;

public class NoRecordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoRecordException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoRecordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoRecordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoRecordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoRecordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
