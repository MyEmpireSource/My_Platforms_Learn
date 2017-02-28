package comlearn.aop.service.impl.nomal;

import com.learn.aop.service.ArithmeticCalculator;

/**
 * 
 * @Package: com.spring4.learn.aop.service.impl
 * @ClassName: ArithmeticCalculatorNomalImpl.java
 *
 * @Description: 数学计算器一般实现
 * 				  需求1-日志：在程序执行期间追踪正在发生的活动
 * 				  需求2-验证：希望计算器只能处理正数的运算
 * 
 * 				  分析:
 * 				  	代码混乱：
 * 						越来越多的非业务需求(日志和验证等)加入后, 原有的业务方法急剧膨胀.  
 * 						每个方法在处理核心逻辑的同时还必须兼顾其他多个关注点. 
 * 					代码分散: 
 * 						以日志需求为例, 只是为了满足这个单一需求, 就不得不在多个模块（方法）里多次重复相同的日志代码. 
 * 						如果日志需求发生变化, 必须修改所有模块.
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月20日 下午4:01:12
 * @UpdateDate: 2017年2月20日 下午4:01:12
 * @Version: V1.0
 */
public class ArithmeticCalculatorNomalImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		
		//开始日志记录
		System.out.println("The ArithmeticCalculator.add() method begins with[" + i + ", " + j + "] ... ...");
		
		int result = -1;
		//验证只能处理正数的运算
		if (i < 0 || j < 0) {
			System.out.println("The ArithmeticCalculator.add() method, The parameter is not a positive number ... ...");
			//结束日志记录
			System.out.println("The ArithmeticCalculator.add() method ends with " + result + " ... ...");
			return result;
		}
		
		result = i + j;
		
		//结束日志记录
		System.out.println("The ArithmeticCalculator.add() method ends with " + result + " ... ...");
		return result;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		//开始日志记录
		System.out.println("The ArithmeticCalculator.sub() method begins with[" + i + ", " + j + "] ... ...");
		
		int result = -1;
		//验证只能处理正数的运算
		if (i < 0 || j < 0) {
			System.out.println("The ArithmeticCalculator.sub() method, The parameter is not a positive number ... ...");
			//结束日志记录
			System.out.println("The ArithmeticCalculator.sub() method ends with " + result + " ... ...");
			return result;
		}
		
		result = i - j;
		
		//结束日志记录
		System.out.println("The ArithmeticCalculator.sub() method ends with " + result + " ... ...");
		return result;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		//开始日志记录
		System.out.println("The ArithmeticCalculator.mul() method begins with[" + i + ", " + j + "] ... ...");
		
		int result = -1;
		//验证只能处理正数的运算
		if (i < 0 || j < 0) {
			System.out.println("The ArithmeticCalculator.mul() method, The parameter is not a positive number ... ...");
			//结束日志记录
			System.out.println("The ArithmeticCalculator.mul() method ends with " + result + " ... ...");
			return result;
		}
		
		result = i * j;
		
		//结束日志记录
		System.out.println("The ArithmeticCalculator.mul() method ends with " + result + " ... ...");
		return result;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		//开始日志记录
		System.out.println("The ArithmeticCalculator.div() method begins with[" + i + ", " + j + "] ... ...");
		
		int result = -1;
		//验证只能处理正数的运算
		if (i < 0 || j < 0) {
			System.out.println("The ArithmeticCalculator.div() method, The parameter is not a positive number ... ...");
			//结束日志记录
			System.out.println("The ArithmeticCalculator.div() method ends with " + result + " ... ...");
			return result;
		}
		
		result = i / j;
		
		//结束日志记录
		System.out.println("The ArithmeticCalculator.div() method ends with " + result + " ... ...");
		return result;
	}

}
