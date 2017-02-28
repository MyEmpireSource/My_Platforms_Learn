package com.learn.aop.service;

/**
 * 
 * @Package: com.spring4.learn.aop.service
 * @ClassName: ArithmeticCalculator.java
 *
 * @Description: 数学计算器接口
 * 				  需求1-日志：在程序执行期间追踪正在发生的活动
 * 				  需求2-验证：希望计算器只能处理正数的运算
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月20日 下午3:54:15
 * @UpdateDate: 2017年2月20日 下午3:54:15
 * @Version: V1.0
 */
public interface ArithmeticCalculator {
	
	int add(int i, int j);
	int sub(int i, int j);
	
	int mul(int i, int j);
	int div(int i, int j);
	
}
