package com.spring4.learn.webproject.transaction.aop.aspect;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.jdbc.BadSqlGrammarException;

import com.spring4.learn.webproject.util.exception.LogicErrorException;
import com.spring4.learn.webproject.util.exception.WarnException;
import com.spring4.learn.webproject.util.log.LoggerFactory;

/**
 * 
 * @Package: com.spring4.learn.webproject.transaction.aop.aspect
 * @ClassName: DaoLoggerAspect.java
 *
 * @Description: DAO普通日志和异常日志记录切面
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年4月1日 上午11:13:57
 * @UpdateDate: 2017年4月1日 上午11:13:57
 * @Version: V1.0
 */
//@Aspect
//@Component
public class DaoLoggerAspect {
	
	//@Before("com.spring4.learn.webproject.transaction.aop.aspect.AspectPointcut.declareJointPointExpressionForDAO()")
	public void beforeMethodForDao(JoinPoint joinPoint) {
		
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
	
	public void afterThrowingForDao(JoinPoint joinPoint, Exception ex) {
		
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		Logger logger = LoggerFactory.getLoggerByName(className);
		String loggerInfo = "";
		
		if (ex instanceof WarnException) {
			loggerInfo = "警告: [" + className + "." + methodName + "()]-";
			loggerInfo += "[Params:{" + args.toString() + "}]-[Occurs By: " + ex.getMessage() + "]";;
			
			//"Into [" + className + "." + methodName + "()]-[Params:{" + args.toString() + "}]-[Occurs Exception: " + ex.getMessage();
			logger.warn(loggerInfo);
		} else if (ex instanceof LogicErrorException) {
			loggerInfo = "逻辑异常: [" + className + "." + methodName + "()]-";
			loggerInfo += "[Params:{" + args.toString() + "}]-[Occurs By: " + ex.getMessage() + "]";;
			
			//"Into [" + className + "." + methodName + "()]-[Params:{" + args.toString() + "}]-[Occurs Exception: " + ex.getMessage();
			logger.error(loggerInfo);
		} else if (ex instanceof BadSqlGrammarException) {
			loggerInfo = "SQL 语句语法或参数出错  [" + className + "." + methodName + "()]-";
			loggerInfo += "[Params:{" + args.toString() + "}]-[Occurs By: " + ex.getMessage() + "]";;
			
			//"Into [" + className + "." + methodName + "()]-[Params:{" + args.toString() + "}]-[Occurs Exception: " + ex.getMessage();
			logger.error(loggerInfo);
		} else {
			loggerInfo = "Error ON [" + className + "." + methodName + "()]-";
			loggerInfo += "[Params:{" + args.toString() + "}]-[Occurs Exception: " + ex.getMessage() + "]";
			
			//"Into [" + className + "." + methodName + "()]-[Params:{" + args.toString() + "}]-[Occurs Exception: " + ex.getMessage();
			logger.error(loggerInfo);
		}
		
	}
	
	public void afterThrowingForDaoByWarnException(JoinPoint joinPoint, WarnException ex) {
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
				
		Logger logger = LoggerFactory.getLoggerByName(className);
		String loggerInfo = "警告: [" + className + "." + methodName + "()]-";
		loggerInfo += "[Params:{" + args.toString() + "}]-[Occurs By: " + ex.getMessage() + "]";;
		
		//"Into [" + className + "." + methodName + "()]-[Params:{" + args.toString() + "}]-[Occurs Exception: " + ex.getMessage();
		logger.warn(loggerInfo);
	}
	
	public void afterThrowingForDaoByLogicErrorException(JoinPoint joinPoint, WarnException ex) {
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
				
		Logger logger = LoggerFactory.getLoggerByName(className);
		String loggerInfo = "逻辑异常: [" + className + "." + methodName + "()]-";
		loggerInfo += "[Params:{" + args.toString() + "}]-[Occurs By: " + ex.getMessage() + "]";;
		
		//"Into [" + className + "." + methodName + "()]-[Params:{" + args.toString() + "}]-[Occurs Exception: " + ex.getMessage();
		logger.warn(loggerInfo);
	}
	
	public void afterThrowingForDaoByBadSqlGrammarException(JoinPoint joinPoint, BadSqlGrammarException ex) {
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
				
		Logger logger = LoggerFactory.getLoggerByName(className);
		String loggerInfo = "SQL 语句语法或参数出错  [" + className + "." + methodName + "()]-";
		loggerInfo += "[Params:{" + args.toString() + "}]-[Occurs By: " + ex.getMessage() + "]";;
		
		//"Into [" + className + "." + methodName + "()]-[Params:{" + args.toString() + "}]-[Occurs Exception: " + ex.getMessage();
		logger.error(loggerInfo);
	}
	
}
