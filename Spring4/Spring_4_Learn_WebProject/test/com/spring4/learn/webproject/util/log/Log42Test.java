package com.spring4.learn.webproject.util.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log42Test {
	
	
	private static final Logger logger = LogManager.getLogger(Log42Test.class);
	
	public static void main(String[] args) throws InterruptedException{
		
		System.out.println(logger.getLevel() + " " + logger.isTraceEnabled());
		
		for (int i = 0; i < 20; i++) {
			logger.trace("TRACE");
			logger.info("INFO");
			logger.debug("DEBUG");
			logger.warn("WARN");
			logger.error("ERROR");
			logger.fatal("FATAL");
			Thread.sleep(2000);
			
			System.out.println(i);;
		}
		
	}
	
}
