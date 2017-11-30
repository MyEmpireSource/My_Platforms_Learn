package com.spring4.learn.webproject.util.log;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerFactory {
	
	private static Map<String, Logger> loggerMap = new HashMap<String, Logger>();
	
	public static Logger getLoggerByName(String loggerName) {
		
		Logger logger = loggerMap.get(loggerName);
		
		if (logger == null) {
			logger = LogManager.getLogger(loggerName);
			loggerMap.put(loggerName, logger);
		}
		
		return logger;
	}
	
}
