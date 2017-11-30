package com.spring4.learn.webproject.transaction.aop.aspect;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import com.spring4.learn.webproject.util.log.LoggerFactory;

/**
 * 
 * @Package: com.spring4.learn.webproject.transaction.aop.aspect
 * @ClassName: ServiceLoggerAspect.java
 *
 * @Description: Service普通日志和异常日志记录切面
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年4月5日 下午3:23:30
 * @UpdateDate: 2017年4月5日 下午3:23:30
 * @Version: V1.0
 */
public class ServiceLoggerAspect {
	
public void beforeMethodForService(JoinPoint joinPoint) {
		
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
				
		Logger logger = LoggerFactory.getLoggerByName(className);
		String loggerInfo = "Into [" + className + "." + methodName + "()]-";
		loggerInfo += "[Params:{" + args.toString() + "}]";
		
		//"Into [" + className + "." + methodName + "()]-[Params:{" + args.toString() + "}]";
		logger.info(loggerInfo);
		
	}
	
}
