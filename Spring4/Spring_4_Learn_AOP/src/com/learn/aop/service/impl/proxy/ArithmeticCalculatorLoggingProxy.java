package com.learn.aop.service.impl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.learn.aop.service.ArithmeticCalculator;

/**
 * 
 * @Package: com.spring4.learn.aop.service.impl.proxy
 * @ClassName: ArithmeticCalculatorLoggingProxy.java
 *
 * @Description: 计算器日志代理对象
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月21日 上午11:38:51
 * @UpdateDate: 2017年2月21日 上午11:38:51
 * @Version: V1.0
 */
public class ArithmeticCalculatorLoggingProxy {
	
	//要代理的对象
	private ArithmeticCalculator arithmeticCalculator;
	
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.arithmeticCalculator = target;
	}
	
	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator arithmeticCalculatorProxy = null;
		
		// 代理对象由哪一个类加载器负责加载
		ClassLoader loader = arithmeticCalculator.getClass().getClassLoader();
		
		// 代理对象的类型, 即其中有哪些方法
		Class[] interfaces = new Class[] {ArithmeticCalculator.class};
		
		//当调用代理对象其中的方法时, 该执行的方法
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * 
			 * @Description: 当调用代理对象其中的方法时, 该执行的方法
			 * 
			 * @Params:
			 * @param proxy	: 	正在返回的那个对象, 一般情况下, 在 invoke 方法中都不使用该对象, 会产生死循环
			 * @param method : 正在被调用的方法
			 * @param args : 调用方法时传入的参数
			 *
			 * @Throws:
			 *
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				
				System.out.println("In ArithmeticCalculatorLoggingProxy, invoke ... ...");
				
				String methodName = method.getName();
				//开始日志
				System.out.println("The ArithmeticCalculator." + methodName + "() method begins with" + Arrays.toString(args) + " ... ...");
				
				//执行方法
				Object result = method.invoke(arithmeticCalculator, args);
				
				//结束日志记录
				System.out.println("The ArithmeticCalculator." + methodName + "() method ends with " + result + " ... ...");
				
				return result;
			}
		};
		
		
		
		arithmeticCalculatorProxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
				
		return arithmeticCalculatorProxy;
	}
}
