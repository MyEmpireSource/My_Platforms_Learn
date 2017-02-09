package com.spring4.learn.bean.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 
 * @Package: com.spring4.learn.bean.cycle
 * @ClassName: MyBeanPostProcessor.java
 *
 * @Description: Spring IOC 容器 使用后置处理器 对 Bean 的生命周期进行管理的过程: 
 * 					通过构造器或工厂方法创建 Bean 实例 
 * 					为 Bean 的属性设置值和对其他 Bean 的引用 
 * 					将 Bean 实例传递给 Bean 后置处理器的 postProcessBeforeInitialization 方法 处理Bean 
 * 					调用 Bean 的初始化方法 
 * 					将 Bean 实例传递给 Bean 后置处理器的 postProcessAfterInitialization方法 处理Bean
 * 					Bean 可以使用了 
 * 					当容器关闭时, 调用 Bean 的销毁方法
 * 
 * 				 
 * 				 Bean 后置处理器允许在调用 初始化方法(init-method) 前后对 Bean 进行额外的处理.
 * 				 Bean 后置处理器对 IOC 容器里的所有 Bean 实例逐一处理, 而非单一实例. 
 * 					其典型应用是: 检查 Bean 属性的正确性或根据特定的标准更改 Bean 的属性.
 * 				  对Bean 后置处理器而言, 需要实现 org.springframework.beans.factory.config.BeanPostProcessor 接口. 
 * 					在初始化方法被调用前后, Spring 将把每个 Bean 实例分别传递给上述接口的以下两个方法:
 * 					BeanPostProcessor.postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
 * 					BeanPostProcessor.postProcessAfterInitialization(Object bean, String beanName) throws BeansException
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月9日 下午3:01:45
 * @UpdateDate: 2017年2月9日 下午3:01:45
 * @Version: V1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	/**
	 * 
	 * @Title: postProcessAfterInitialization
	 * @Description: 在 Bean初始化方法(inti_method)调用之后 调用
	 * 
	 * @Params:
	 *   @param bean : Bean 实例本身
	 *   @param beanName : IOC容器中配置的Bean的名字
	 *
	 * @Return: Objetc : 是实际上返回给用户的那个Bean
	 * 			注意 : 可以在以上两个方法中修改返回的Bean, 甚至返回一个新的Bean
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月9日 下午3:28:32
	 * @ChangeDate: 2017年2月9日 下午3:28:32
	 * @Author: ZCX
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		
		//Bean后置处理器处理所有Bean, 可以根据需要过滤
		
		if ("car".equals(beanName)) {
			//....
		}
		
		System.out.println("MyBeanPostProcessor.postProcessAfterInitialization... ... " + beanName + ", " + bean);
		return bean;
	}

	/**
	 * 
	 * @Title: postProcessBeforeInitialization
	 * @Description: 在 Bean初始化方法(inti_method)调用之前 调用
	 * 
	 * @Params:
	 *   @param bean : Bean 实例本身
	 *   @param beanName : IOC容器中配置的Bean的名字
	 *
	 * @Return: Objetc : 是实际上返回给用户的那个Bean
	 * 			注意 : 可以在以上两个方法中修改返回的Bean, 甚至返回一个新的Bean
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2017年2月9日 下午3:28:32
	 * @ChangeDate: 2017年2月9日 下午3:28:32
	 * @Author: ZCX
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization... ... " + beanName + ", " + bean);
		return bean;
	}

}
