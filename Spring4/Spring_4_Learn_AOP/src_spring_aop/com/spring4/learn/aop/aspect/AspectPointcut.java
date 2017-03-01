package com.spring4.learn.aop.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @Package: com.spring4.learn.aop.aspect
 * @ClassName: AspectPointcut.java
 *
 * @Description: 切入点表达式
 * 				   定义一个方法, 用于声明切入点表达式, 一般的, 该方法中再不需要添加入其它代码
 * 				   使用 @Pointcut 来声明切入点表达式
 * 				   后面其它通知直接使用方法名来引用当前的切入点表达式
 * 				
 * 				   使用例子 : com.spring4.learn.aop.aspect.OtherAspectUsePointcut
 * 
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年3月1日 下午4:16:02
 * @UpdateDate: 2017年3月1日 下午4:16:02
 * @Version: V1.0
 */
@Aspect
@Component
public class AspectPointcut {
	
	/**
	 * 
	 * @Title: declareJointPointExpressionForAdd
	 * @Description: 
	 * 				 定义切入点表达式
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年3月1日 下午4:18:08
	 * @ChangeDate: 2017年3月1日 下午4:18:08
	 * @Author: ZCX
	 */
	@Pointcut("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.add(int, int))")
	public void declareJointPointExpressionForAdd(){}
	
	@Pointcut("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(..))")
	public void declareJointPointExpressionForAll(){}
	
	@Pointcut("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))")
	public void declareJointPointExpressionForAfterMethodReturning() {}
	
	@Pointcut("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))")
	public void declareJointPointExpressionForAfterMethodThrowing() {}
	
	
	
	@Before("declareJointPointExpressionForAdd()")
	public void beforeMethod(JoinPoint joinPoint) {
		
		
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println();
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		System.out.println("AspectPointcut ---> The " + className + "." + methodName + "() method beginng with " + args + "  ... ...");
		System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
		System.out.println();
	}
}
