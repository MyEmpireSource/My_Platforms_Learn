package com.spring4.learn.aop.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 * @Package: com.spring4.learn.aop.aspect
 * @ClassName: OtherAspectUsePointcut.java
 *
 * @Description: 切入点表达式
 * 				   定义一个方法, 用于声明切入点表达式, 一般的, 该方法中再不需要添加入其它代码
 * 				   使用 @Pointcut 来声明切入点表达式
 * 				   后面其它通知直接使用方法名来引用当前的切入点表达式
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年3月1日 下午4:28:29
 * @UpdateDate: 2017年3月1日 下午4:28:29
 * @Version: V1.0
 */
@Aspect
@Component
public class OtherAspectUsePointcut {
	
	
	@Before("com.spring4.learn.aop.aspect.AspectPointcut.declareJointPointExpressionForAll()")
	public void beforeMethod(JoinPoint joinPoint) {
		
		
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println();
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		System.out.println("OtherAspectUsePointcut ---> The " + className + "." + methodName + "() method beginng with " + args + "  ... ...");
		System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
		System.out.println();
	}
	
	
	@AfterReturning(value="com.spring4.learn.aop.aspect.AspectPointcut.declareJointPointExpressionForAfterMethodReturning()", returning="returnResult")
	public void afterMethodReturning(JoinPoint joinPoint, Object returnResult) {
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println();
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		System.out.println("OtherAspectUsePointcut ---> The " + className + "." + methodName + "() method AfterReturning, ends with " + returnResult + " ... ...");
		System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
		System.out.println();
	}
	
	
	@AfterThrowing(value="com.spring4.learn.aop.aspect.AspectPointcut.declareJointPointExpressionForAfterMethodThrowing()", throwing="ex")
	public void afterMethodThrowing(JoinPoint joinPoint, Exception ex) {
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		
		System.out.println();
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		System.out.println("OtherAspectUsePointcut ---> The " + className + "." + methodName + "() method afterThrowing, Occurs Exception is : " + ex.getMessage() + " ... ...");
		System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
		System.out.println();
	}
	
}
