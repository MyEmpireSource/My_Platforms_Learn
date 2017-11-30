package com.spring4.learn.webproject.transaction.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @Package: com.spring4.learn.webproject.transaction.aop.aspect
 * @ClassName: AspectPointcut.java
 *
 * @Description: 切入点表达式
 * 				   定义一个方法, 用于声明切入点表达式, 一般的, 该方法中再不需要添加入其它代码
 * 				   使用 @Pointcut 来声明切入点表达式
 * 				   后面其它通知直接使用方法名来引用当前的切入点表达式
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年3月31日 上午12:29:28
 * @UpdateDate: 2017年3月31日 上午12:29:28
 * @Version: V1.0
 */
//@Component
//@Aspect
public class AspectPointcut {
	
	/**
	 * 
	 * @Title: declareJointPointExpressionForDAO
	 * @Description: TODO(用一句话描述该文件做什么)
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年3月31日 下午3:17:11
	 * @ChangeDate: 2017年3月31日 下午3:17:11
	 * @Author: ZCX
	 */
	//@Pointcut("execution (* com.spring4.learn.webproject.transaction.dao.*.*(..))")
	public void declareJointPointExpressionForAllDAO(){}
	/*
	@Pointcut("execution (* com.spring4.learn.webproject.transaction.service.*.*(..))")
	public void declareJointPointExpressionForService() {}
	*/
}
