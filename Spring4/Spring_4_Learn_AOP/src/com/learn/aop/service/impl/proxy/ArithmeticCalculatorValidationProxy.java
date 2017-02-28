package com.learn.aop.service.impl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ArithmeticCalculatorValidationProxy implements InvocationHandler{

	private Object target;
	
	public ArithmeticCalculatorValidationProxy(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("In ArithmeticCalculatorValidationProxy, invoke ... ...");
		
		try {
			for (Object arg : args){
				validat((int) arg);
			}
			
			Object result = method.invoke(target, args);
			return result;
		} catch (IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
			
			return -1;
		} catch (Exception e) {
			
			System.out.println("Other Exception : " + e.getMessage());
			return -1;
		}
		
	}
	
	public static Object createProxy(Object target) {
		
		return Proxy.newProxyInstance(
					target.getClass().getClassLoader(), 
					target.getClass().getInterfaces(), 
					new ArithmeticCalculatorValidationProxy(target));
		
	}
	
	private void validat (int a) {
		if (a < 0) {
			throw new IllegalArgumentException("Positive number only !!!");
		}
	}
}
