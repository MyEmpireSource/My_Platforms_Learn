package com.spring4.learn.aop.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @Package: com.spring4.learn.aop.service.impl.proxy
 * @ClassName: ArithmeticCalculatorProxyImpl.java
 *
 * @Description: 使用动态代理解决问题
 * 				  数学计算器一般实现
 * 				  需求1-日志：在程序执行期间追踪正在发生的活动
 * 				  需求2-验证：希望计算器只能处理正数的运算
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月24日 上午11:38:23
 * @UpdateDate: 2017年2月24日 上午11:38:23
 * @Version: V1.0
 */
// @Component("arithmeticCalculator")
//非单例模式
// @Scope("prototype")
public class ArithmeticCalculatorImpl implements com.spring4.learn.aop.service.ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		int result = i + j;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		int result = i - j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		int result = i * j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		int result = i / j;
		return result;
	}

}
