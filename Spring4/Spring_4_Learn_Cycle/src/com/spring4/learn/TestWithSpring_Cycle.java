package com.spring4.learn;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.bean.cycle.CarForCycle;

public class TestWithSpring_Cycle {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext_bean_cycle.xml");
		
		
		
		CarForCycle car = (CarForCycle) cxt.getBean("carForCycle");
		
		CarForCycle car2 = (CarForCycle) cxt.getBean("carForCycle");
		
		System.out.println();
		System.out.println(car);
		System.out.println(car2);
		System.out.println();
		
		//关闭IOC容器
		cxt.close();
		
		
		/**
		 * CarForCycle's Constructor... ...  (先调构造器)
		 * setBrand... ...					 (设置属性)
		 * CarForCycle init... ...			 (然后调初始化方法)
		 * CarForCycle [brand=Audio]		 (初始化后可以返回Bean实例)
		 * CarForCycle destory... ...		 (IOC容器关闭, 销毁Bean实例)
		 */
	}
	
}
