package com.spring4.learn.poio.properties;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Package: com.spring4.learn.poio.properties
 * @ClassName: TestWithSpring_Properties.java
 *
 * @Description: xml配置学习(applicationContext_properties.xml)
 * 				   使用外部属性文件
 * 					
 * 				   在配置文件里配置 Bean 时, 有时需要在 Bean 的配置里混入系统部署的细节信息(例如: 文件路径, 数据源配置信息等). 
 *               而这些部署细节实际上需要和 Bean 配置相分离
 *               
 *               Spring 提供了一个 PropertyPlaceholderConfigurer 的 BeanFactory 后置处理器, 
 *               这个处理器允许用户将 Bean 配置的部分内容外移到属性文件中. 
 *				   可以在 Bean 配置文件里使用形式为 ${var} 的变量, 
 *               PropertyPlaceholderConfigurer 从属性文件里加载属性, 并使用这些属性来替换变量
 *               
 *               Spring 还允许在属性文件中使用 ${propName}，以实现属性之间的相互引用
 *               
 *               Spring 2.5 之后: 可通过 <context:property-placeholder> 元素简化
 *              
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月8日 上午11:20:16
 * @UpdateDate: 2017年2月8日 上午11:20:16
 * @Version: V1.0
 */
public class TestWithSpring_Properties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext_properties.xml");
			
			DataSource dataSource = (DataSource) cxt.getBean("dataSource");
			System.out.println(dataSource);
			System.out.println(dataSource.getConnection());
			
			System.out.println();
			System.out.println();
			
			DataSource dataSource_properties = (DataSource) cxt.getBean("dataSource_properties");
			System.out.println(dataSource_properties);
			System.out.println(dataSource_properties.getConnection());
			
			System.out.println();
			System.out.println(dataSource.equals(dataSource_properties));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
