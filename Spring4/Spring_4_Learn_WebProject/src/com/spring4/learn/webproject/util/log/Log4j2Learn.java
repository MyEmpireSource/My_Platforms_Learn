package com.spring4.learn.webproject.util.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Learn {
	
	/*
	 * 如果我们在工程(项目)中不提供log4j的配置(classpath:log4j2.xml)文件，则log4j会使用默认的配置，级别为error 
	 * 4种获取日志记录器的方式 
	 */
	private static Logger logger_1 = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);  
    private static Logger logger_2 = LogManager.getLogger(Log4j2Learn.class);  
    private static Logger logger_3 = LogManager.getLogger(Log4j2Learn.class.getName());  
    private static Logger logger_4 = LogManager.getRootLogger();  
    
    public static void main(String[] args) {
    	System.out.println(logger_1.getLevel() + " " + logger_1.isTraceEnabled());
    	System.out.println(logger_2.getLevel() + " " + logger_2.isTraceEnabled());
    	System.out.println(logger_3.getLevel() + " " + logger_3.isTraceEnabled());
    	System.out.println(logger_4.getLevel() + " " + logger_4.isTraceEnabled());
		System.out.println();
		
		System.out.println("↓↓↓↓↓↓↓↓↓↓ logger_1 ↓↓↓↓↓↓↓↓↓↓");
    	logger_1.trace("TRACE");
    	logger_1.info("INFO");
    	logger_1.debug("DEBUG");
    	logger_1.warn("WARN");
    	logger_1.error("ERROR");
    	logger_1.fatal("FATAL");
    	
    	System.out.println();
    	System.out.println("↓↓↓↓↓↓↓↓↓↓ logger_2 ↓↓↓↓↓↓↓↓↓↓");
    	logger_2.trace("TRACE");
    	logger_2.info("INFO");
    	logger_2.debug("DEBUG");
    	logger_2.warn("WARN");
    	logger_2.error("ERROR");
    	logger_2.fatal("FATAL");
    	
    	System.out.println();
    	System.out.println("↓↓↓↓↓↓↓↓↓↓ logger_3 ↓↓↓↓↓↓↓↓↓↓");
    	logger_3.trace("TRACE");
    	logger_3.info("INFO");
    	logger_3.debug("DEBUG");
    	logger_3.warn("WARN");
    	logger_3.error("ERROR");
    	logger_3.fatal("FATAL");
    	
    	System.out.println();
    	System.out.println("↓↓↓↓↓↓↓↓↓↓ logger_4 ↓↓↓↓↓↓↓↓↓↓");
    	logger_4.trace("TRACE");
    	logger_4.info("INFO");
    	logger_4.debug("DEBUG");
    	logger_4.warn("WARN");
    	logger_4.error("ERROR");
    	logger_4.fatal("FATAL");
    }
	
}
