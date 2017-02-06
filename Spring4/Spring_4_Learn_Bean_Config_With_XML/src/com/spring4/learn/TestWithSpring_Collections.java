package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.poio.collections.DataSourceForProperties;
import com.spring4.learn.poio.collections.PersonForCollection;
import com.spring4.learn.poio.collections.PersonForMap;
import com.spring4.learn.poio.collections.PersonForUtil;


public class TestWithSpring_Collections {
	/**
	 * 
	 * @Title: main
	 * @Description:  配置集合属性
	 * 
	 *  			 在 Spring中可以通过一组内置的 xml 标签(例如: <list>, <set> 或 <map>) 来配置集合属性
	 * 				 配置 java.util.List 类型的属性, 需要指定 <list>  标签
	 * 				 数组的定义和 List 一样, 都使用 <list>
	 * 				 配置 java.util.Set 需要使用 <set> 标签
	 * 
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年7月30日 下午5:44:17
	 * @ChangeDate: 2016年7月30日 下午5:44:17
	 * @Author: 李立
	 */
	public static void main(String[] args) {
		//resource="classpath:/applicationContext_collections.xml"
		
		// 1, 创建Spring IOC 容器
		//配置文件在classPath下 (src文件夹下)
		//ApplicationContext 代表 IOC 容器
		//ClassPathXmlApplicationContext: 是ApplicationContext接口实现类 ， 该实现类从类路径下加载配置文件
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		PersonForCollection person = (PersonForCollection) cxt.getBean("person5");
		System.out.println(person);
		
		PersonForMap personMap = (PersonForMap) cxt.getBean("person6");
		System.out.println(personMap);
		
		DataSourceForProperties ds = (DataSourceForProperties) cxt.getBean("dataSource");
		System.out.println(ds);
		
		PersonForUtil personUtil = (PersonForUtil) cxt.getBean("person7");
		System.out.println(personUtil);
		
		personUtil = (PersonForUtil) cxt.getBean("person8");
		System.out.println(personUtil);
		
	}
	
}
