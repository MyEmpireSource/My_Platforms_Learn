package com.spring4.learn.aop.aspect;

import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @Package: com.spring4.learn.aop.scpect
 * @ClassName: LoggingAspect.java
 *
 * @Description: 日志切面
 * 				   把一个类用annotation声明成一个切面: 
 * 					1, 需要把类放入到IOC容器 (@Component)
 * 					2, 再声明为一个切面 (@Aspect)
 * 
 * 				 前置通知 : 在目标方法开始之前执行
 * 				 后置通知 : 在目标方法执行后(无论是否发生异常), 执行的通知。 
 * 						 在后置通知中, 还不能访问目标方法的执行结果
 * 				 返回通知 : 在方法正常结束(没有异常)后执行的代码
 * 						 返回通知 可以访问方法的返回值
 * 				 异常通知 : 在方法发生异常后执行的代码
 * 						 异常通知 可以访问方法发生的异常(异常对象)
 * 						 可以设定是那种异常触发通知(指定在出现特定异常时执行代码)
 * 				 环绕通知 : 功能最强, 可以实现(前置通知, 前置通知, 返回通知, 异常通知)
 * 						 环绕通知是所有通知类型中功能最为强大的, 能够全面地控制连接点. 甚至可以控制是否执行连接点 
 * 						 环绕通知需要携带 ProceedingJoinPoint 类型参数 
 * 						 环绕通知类似于动态代理的全过程 : ProceedingJoinPoint 类型的参数可以决定是否执行目标方法 
 * 						 环绕通知必须有返回值, 返回值即为目标方法的返回值
 * 
 * 				 可以在通知方法中声明一个类型为 JoinPoint 的参数. 然后就能访问链接细节. 如方法名称和参数值
 * 
 * 				可以使用 @Order 注解指定切面的优先级, 值越小, 优先级越高
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月24日 下午3:03:10
 * @UpdateDate: 2017年2月24日 下午3:03:10
 * @Version: V1.0
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * 
	 * @Title: beforeMethod
	 * @Description: 
	 * 				@Before 声明该方法是一个前置通知(在目标方法开始之前执行)
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月24日 下午3:29:26
	 * @ChangeDate: 2017年2月24日 下午3:29:26
	 * @Author: ZCX
	 */
	@Before("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.add(int, int))")
	public void beforeMethod() {
		System.out.println("The method beginng ... ...");
	}
	
	/**
	 * 
	 * @Title: beforeMethod
	 * @Description: TODO(用一句话描述该文件做什么)
	 * 
	 * @Params:
	 *   @param joinPoint 连接点
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月24日 下午4:03:32
	 * @ChangeDate: 2017年2月24日 下午4:03:32
	 * @Author: ZCX
	 */
	@Before("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint) {
		
		
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The " + className + "." + methodName + "() method beginng with " + args + "  ... ...");
	}
	
	
// ****************** 后置通知 : 在目标方法执行后(无论是否发生异常), 执行的通知  ****************** //
	/**
	 * 
	 * @Title: afterMethod
	 * @Description: 
	 * 				@After 声明该方法是一个后置通知(在目标方法执行后(无论是否发生异常), 执行的通知)
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月27日 下午3:03:41
	 * @ChangeDate: 2017年2月27日 下午3:03:41
	 * @Author: ZCX
	 */
	@After("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.add(int, int))")
	public void afterMethod() {
		System.out.println("The method ends ... ...");
	}
	
	/**
	 * 
	 * @Title: afterMethod
	 * @Description: 
	 * 					@After 声明该方法是一个后置通知(在目标方法执行后(无论是否发生异常), 执行的通知)
	 * 					在后置通知中, 还不能访问目标方法的执行结果
	 * 
	 * @Params:
	 *   @param joinPoint 连接点
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月27日 下午3:04:32
	 * @ChangeDate: 2017年2月27日 下午3:04:32
	 * @Author: ZCX
	 */
	@After("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))")
	public void afterMethod(JoinPoint joinPoint) {
		
		
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The " + className + "." + methodName + "() method ends ... ...");
	}
	
	
	
// ****************** 返回通知 : 在方法正常结束后执行的代码  ****************** //
	/**
	 * 
	 * @Title: afterMethodReturning
	 * @Description: 
	 * 				 @AfterReturning : 声明该方法是一个返回通知, 在方法正常结束后执行的代码
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月27日 下午3:58:37
	 * @ChangeDate: 2017年2月27日 下午3:58:37
	 * @Author: ZCX
	 */
	@AfterReturning("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))")
	public void afterMethodReturning() {
		System.out.println("The method AfterReturning ... ...");
	}
	
	/**
	 * 
	 * @Title: afterMethodReturning
	 * @Description: 
	 * 				 @AfterReturning : 声明该方法是一个返回通知, 在方法正常结束后执行的代码
	 * 				  返回通知 可以访问方法的返回值
	 * 
	 * @Params:
	 *   @param joinPoint
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月27日 下午4:00:02
	 * @ChangeDate: 2017年2月27日 下午4:00:02
	 * @Author: ZCX
	 */
	@AfterReturning("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))")
	public void afterMethodReturning(JoinPoint joinPoint) {
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The " + className + "." + methodName + "() method AfterReturning ... ...");
	}
	
	/**
	 * 
	 * @Title: afterMethodReturning
	 * @Description: 
	 * 				 @AfterReturning : 声明该方法是一个返回通知, 在方法正常结束后执行的代码
	 * 				  返回通知 可以访问方法的返回值
	 * 
	 * @Params:
	 *   @param joinPoint
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月27日 下午4:00:02
	 * @ChangeDate: 2017年2月27日 下午4:00:02
	 * @Author: ZCX
	 */
	@AfterReturning(value="execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))", 
					returning = "returnResult")
	public void afterMethodReturning(JoinPoint joinPoint, Object returnResult) {
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The " + className + "." + methodName + "() method AfterReturning, ends with " + returnResult + " ... ...");
	}
	
// ****************** 异常通知 : 在方法发生异常后执行的代码  ****************** //	
	
	/**
	 * 
	 * @Title: afterMethodThrowing
	 * @Description: 
	 * 				 @AfterThrowing : 声明该方法是一个异常通知(在方法发生异常后执行的代码)
	 * 				  异常通知 可以访问方法发生的异常
	 * 
	 * @Params:
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月27日 下午4:42:02
	 * @ChangeDate: 2017年2月27日 下午4:42:02
	 * @Author: ZCX
	 */
	@AfterThrowing("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(..))")
	public void afterMethodThrowing() {
		System.out.println("The method afterThrowing ... ...");
	}
	
	/**
	 * 
	 * @Title: afterMethodThrowing
	 * @Description: 
	 * 				 @AfterThrowing : 声明该方法是一个异常通知(在方法发生异常后执行的代码)
	 * 				  异常通知 可以访问方法发生的异常
	 * 
	 * @Params:
	 *   @param joinPoint
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月27日 下午4:47:01
	 * @ChangeDate: 2017年2月27日 下午4:47:01
	 * @Author: ZCX
	 */
	@AfterThrowing("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))")
	public void afterMethodThrowing(JoinPoint joinPoint) {
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The " + className + "." + methodName + "() method afterThrowing ... ...");
	}
	
	/**
	 * 
	 * @Title: afterMethodThrowing
	 * @Description: 
	 * 				 @AfterThrowing : 声明该方法是一个异常通知(在方法发生异常后执行的代码)
	 * 				  异常通知 可以访问方法发生的异常
	 * 
	 * @Params:
	 *   @param joinPoint
	 *   @param ex
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月27日 下午4:47:09
	 * @ChangeDate: 2017年2月27日 下午4:47:09
	 * @Author: ZCX
	 */
	@AfterThrowing(value="execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))", 
					throwing = "ex")
	public void afterMethodThrowing(JoinPoint joinPoint, Exception ex) {
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The " + className + "." + methodName + "() method afterThrowing, Occurs Exception is : " + ex.getMessage() + " ... ...");
	}
	
	/**
	 * 
	 * @Title: afterMethodThrowing
	 * @Description: 
	 * 				 @AfterThrowing : 声明该方法是一个返回异常通知(在方法发生异常后执行的代码)
	 * 				  返回通知 可以访问方法发生的异常(异常对象)
	 * 				  可以设定是那种异常触发通知(指定在出现特定异常时执行代码)
	 * 
	 * @Params:
	 *   @param joinPoint
	 *   @param ex : 设定是 NullPointerException 异常触发通知
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月27日 下午4:51:04
	 * @ChangeDate: 2017年2月27日 下午4:51:04
	 * @Author: ZCX
	 */
	@AfterThrowing(value="execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))", 
					throwing = "ex")
	public void afterMethodThrowing(JoinPoint joinPoint, NullPointerException ex) {
		String className = joinPoint.getSignature().getDeclaringType().getName();
		String methodName = joinPoint.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The " + className + "." + methodName + "() method afterThrowing, Occurs By NullPointerException, Exception is : " + ex.getMessage() + " ... ...");
	}
	

	
// ****************** 环绕通知 : 围绕着方法执行  ****************** //		
	/**
	 * 
	 * @Title: aroundMethod
	 * @Description: 
	 * 				 @Around : 声明一个环绕通知
	 * 				  环绕通知需要携带 ProceedingJoinPoint 类型参数
	 * 				  环绕通知类似于动态代理的全过程 : ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
	 * 				  环绕通知必须有返回值, 返回值即为目标方法的返回值
	 * 
	 * @Params:
	 *   @param pjp
	 *   @return
	 *
	 * @Return: Object
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月28日 下午3:34:19
	 * @ChangeDate: 2017年2月28日 下午3:34:19
	 * @Author: ZCX
	 */
	@Around("execution (int com.spring4.learn.aop.service.ArithmeticCalculator.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		
		Object result = null;
		
		String className = pjp.getSignature().getDeclaringType().getName();
		String methodName = pjp.getSignature().getName();
		
		//参数
		List<Object> args = Arrays.asList(pjp.getArgs());
		
		try {
			//前置通知
			System.out.println("Around Notice: The " + className + "." + methodName + "() method beginng with " + args + "  ... ...");
			
			//执行目标方法
			//ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
			result = pjp.proceed();
			
			//返回通知
			System.out.println("Around Notice: The " + className + "." + methodName + "() method AfterReturning, ends with " + result + " ... ...");
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			// 异常通知
			System.out.println("Around Notice: The " + className + "." + methodName + "() method afterThrowing, Occurs Exception is : " + e.getMessage() + " ... ...");
			throw new RuntimeException(e);
		}
		
		//后置通知, 因为方法可能会发生异常, 所以不能访问返回值
		System.out.println("Around Notice: The " + className + "." + methodName + "() method ends ... ...");
		
		return result;
	}
	
	
}
