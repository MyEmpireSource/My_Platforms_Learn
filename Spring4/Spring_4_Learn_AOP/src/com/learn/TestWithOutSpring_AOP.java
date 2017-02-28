package com.learn;

import com.learn.aop.service.ArithmeticCalculator;
import com.learn.aop.service.impl.proxy.ArithmeticCalculatorLoggingProxy;
import com.learn.aop.service.impl.proxy.ArithmeticCalculatorProxyImpl;
import com.learn.aop.service.impl.proxy.ArithmeticCalculatorValidationProxy;

import comlearn.aop.service.impl.nomal.ArithmeticCalculatorNomalImpl;

public class TestWithOutSpring_AOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Nomal Test
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ Nomal Test Show Start ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓\n");
		ArithmeticCalculator arithmeticCalculatorNomal = new ArithmeticCalculatorNomalImpl();
		arithmeticCalculatorNomal.add(1, 2);
		System.out.println();
		arithmeticCalculatorNomal.div(4, 2);
		System.out.println();
		arithmeticCalculatorNomal.mul(-4, 2);
		System.out.println();
		System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ Nomal Test Show End   ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n");
		
		// 使用动态代理
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ Proxy Test Show Start ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓\n");
		ArithmeticCalculator arithmeticCalculatorTarget = new ArithmeticCalculatorProxyImpl();
		ArithmeticCalculator arithmeticCalculatorProxy = (new ArithmeticCalculatorLoggingProxy(arithmeticCalculatorTarget)).getLoggingProxy();
		
		arithmeticCalculatorProxy = (ArithmeticCalculator) ArithmeticCalculatorValidationProxy.createProxy(arithmeticCalculatorProxy);
		
		arithmeticCalculatorProxy.add(1, 2);
		System.out.println();
		arithmeticCalculatorProxy.div(4, 2);
		System.out.println();
		arithmeticCalculatorProxy.mul(-4, 2);
		System.out.println();
		arithmeticCalculatorProxy.mul(4, 2);
		System.out.println();
		System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ Proxy Test Show End   ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n");
	}

}
