package com.spring4.learn.webproject.transaction.init.service.impl;

import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.spring4.learn.webproject.transaction.init.service.InitServiceDemo;
import com.spring4.learn.webproject.util.FormatTime;

@Service("initServiceDemo")
public class InitServiceDemoImpl implements InitServiceDemo {

	/**
	 * 
	 * @Override
	 * (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 *
	 *
	 * @Title: setApplicationContext
	 * @Description: ApplicationContextAware 接口定义方法
	 * 
	 * @Params:
	 *   @param arg0
	 *   @throws BeansException
	 *
	 * @Return: 
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年2月5日 上午10:23:40
	 * @ChangeDate: 2016年2月5日 上午10:23:40
	 * @Author: 李立
	 */
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		// TODO Auto-generated method stub
//First		
		System.out.println();
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓ " + FormatTime.getFormatDateTime(new Date()) + " ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		System.out.println("org.springframework.context.ApplicationContextAware#setApplicationContext()");
		System.out.println(ctx.getApplicationName());
		System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑ " + FormatTime.getFormatDateTime(new Date()) + " ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
		System.out.println();
		
	}

	/**
	 * 
	 * @Override
	 * (non-Javadoc)
	 * @see org.springframework.web.context.ServletContextAware#setServletContext(javax.servlet.ServletContext)
	 *
	 *
	 * @Title: setServletContext
	 * @Description: ServletContextAware 接口定义方法
	 * 
	 * @Params:
	 *   @param arg0
	 *
	 * @Return: 
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年2月5日 上午10:24:18
	 * @ChangeDate: 2016年2月5日 上午10:24:18
	 * @Author: 李立
	 */
	@Override
	public void setServletContext(ServletContext ctx) {
		// TODO Auto-generated method stub
//Second		
		System.out.println();
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓ " + FormatTime.getFormatDateTime(new Date()) + " ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		System.out.println("org.springframework.web.context.ServletContextAware#setServletContext()");
		System.out.println(ctx.getContextPath());
		System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑ " + FormatTime.getFormatDateTime(new Date()) + " ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
		System.out.println();
	}

	/**
	 * 
	 * @Override
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 *
	 *
	 * @Title: afterPropertiesSet
	 * @Description: InitializingBean 接口定义方法
	 * 
	 * @Params:
	 *   @throws Exception
	 *
	 * @Return: 
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年2月5日 上午10:25:10
	 * @ChangeDate: 2016年2月5日 上午10:25:10
	 * @Author: 李立
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
//Third		
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓ " + FormatTime.getFormatDateTime(new Date()) + " ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		System.out.println("org.springframework.beans.factory.InitializingBean#afterPropertiesSet()");
		System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑ " + FormatTime.getFormatDateTime(new Date()) + " ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
		System.out.println();
	}

	/**
	 * 
	 * @Override
	 * (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 *
	 *
	 * @Title: onApplicationEvent
	 * @Description: ApplicationListener<ContextRefreshedEvent> 接口定义方法
	 * 
	 * @Params:
	 *   @param arg0
	 *
	 * @Return: 
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年2月5日 上午10:25:57
	 * @ChangeDate: 2016年2月5日 上午10:25:57
	 * @Author: 李立
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//Last		
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("###↓↓↓↓↓↓↓↓↓↓↓↓↓ " + FormatTime.getFormatDateTime(new Date()) + " ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓###");
		System.out.println("org.springframework.context.ApplicationListener#onApplicationEvent()");
		System.out.println(event.getApplicationContext().getDisplayName());
		System.out.println("###↑↑↑↑↑↑↑↑↑↑↑↑↑ " + FormatTime.getFormatDateTime(new Date()) + " ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑###");
		System.out.println();
		
		//root application context 没有parent，他就是老大.
		if (event.getApplicationContext().getParent() == null) {
			
	        //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			//需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			System.out.println();
			System.out.println("$$$↓↓↓↓↓↓↓↓↓↓↓↓↓ " + FormatTime.getFormatDateTime(new Date()) + " ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓$$$");
			System.out.println("org.springframework.context.ApplicationListener#onApplicationEvent()");
			System.out.println(event.getApplicationContext().getDisplayName());
			System.out.println("$$$↑↑↑↑↑↑↑↑↑↑↑↑↑ " + FormatTime.getFormatDateTime(new Date()) + " ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑$$$");
			System.out.println();
		}
	}

}

