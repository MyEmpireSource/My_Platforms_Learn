package com.spring4.learn.bean.cycle;

/**
 * 
 * @Package: com.spring4.learn.bean.cycle
 * @ClassName: CarForCycle.java
 *
 * @Description: Spring 容器对Bean生命周期的管理
 * 				 Spring IOC 容器对 Bean 的生命周期进行管理的过程: 
 * 					通过构造器或工厂方法创建 Bean 实例 
 * 					为 Bean 的属性设置值和对其他 Bean 的引用 
 * 					调用 Bean 的初始化方法 
 * 					Bean 可以使用了 
 * 					当容器关闭时, 调用 Bean 的销毁方法
 * 				 
 * 				  在 Bean 的声明里设置 init-method 和 destroy-method 属性, 为 Bean 指定初始化和销毁方法
 * 
 * 				 Spring IOC 容器 使用后置处理器 对 Bean 的生命周期进行管理的过程: 
 * 					通过构造器或工厂方法创建 Bean 实例 
 * 					为 Bean 的属性设置值和对其他 Bean 的引用 
 * 					将 Bean 实例传递给 Bean 后置处理器的 postProcessBeforeInitialization 方法 处理Bean 
 * 					调用 Bean 的初始化方法 
 * 					将 Bean 实例传递给 Bean 后置处理器的 postProcessAfterInitialization方法 处理Bean
 * 					Bean 可以使用了 
 * 					当容器关闭时, 调用 Bean 的销毁方法
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月9日 上午11:29:40
 * @UpdateDate: 2017年2月9日 上午11:29:40
 * @Version: V1.0
 */
public class CarForCycle {
	
	private String brand;

	public CarForCycle() {
		System.out.println("CarForCycle's Constructor... ...");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("setBrand... ...");
		this.brand = brand;
	}
	
	public void initOfCar() {
		System.out.println("CarForCycle init... ...");
	}
	
	public void carDestory() {
		System.out.println("CarForCycle destory... ...");
	}

	@Override
	public String toString() {
		return "CarForCycle [brand=" + brand + "]";
	}
	
	
}
