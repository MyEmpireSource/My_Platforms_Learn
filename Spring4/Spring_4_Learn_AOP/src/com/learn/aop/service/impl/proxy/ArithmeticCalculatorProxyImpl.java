package com.learn.aop.service.impl.proxy;

import com.learn.aop.service.ArithmeticCalculator;

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
 * @CreateDate: 2017年2月21日 上午11:34:45
 * @UpdateDate: 2017年2月21日 上午11:34:45
 * @Version: V1.0
 */
public class ArithmeticCalculatorProxyImpl implements ArithmeticCalculator {

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
