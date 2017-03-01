package com.spring4.learn.aop.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @Package: com.spring4.learn.aop.aspect
 * @ClassName: VlidationAspect.java
 *
 * @Description: 验证切面
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年3月1日 下午3:08:58
 * @UpdateDate: 2017年3月1日 下午3:08:58
 * @Version: V1.0
 */
//可以使用 @Order 注解指定切面的优先级, 值越小, 优先级越高
@Order(1)
@Aspect
@Component
public class VlidationAspect {
	
	@Around("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))")
	public Object vlidationArgs(ProceedingJoinPoint pjp) {
		String className = pjp.getSignature().getDeclaringType().getName();
		String methodName = pjp.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(pjp.getArgs());
		Object result = null;
		
		try {
			for (Object arg : args){
				validat((int) arg);
			}
			
			System.out.println("VlidationAspect done with " + args + " ... ...");;
			
			result = pjp.proceed();
			
		} catch (IllegalArgumentException e) {
			
			System.out.println("VlidationAspect Error : " + e.getMessage());
			
			//throw new RuntimeException(e);
			return -1;
		} catch (Exception e) {
			
			System.out.println("VlidationAspect Error, Other Exception : " + e.getMessage());
			//throw new RuntimeException(e);
			return -1;
		} catch (Throwable e) {
			System.out.println("Around Notice: The " + className + "." + methodName + "() method afterThrowing, Occurs Exception is : " + e.getMessage() + " ... ...");
			//throw new RuntimeException(e);
			return -1;
		}
		
		return result;
		
	}
	
	private void validat (int a) {
		if (a < 0) {
			throw new IllegalArgumentException("Positive number only !!!");
		}
	}
}
