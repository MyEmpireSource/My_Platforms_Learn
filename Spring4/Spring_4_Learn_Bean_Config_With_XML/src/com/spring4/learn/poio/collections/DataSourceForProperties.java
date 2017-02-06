package com.spring4.learn.poio.collections;

import java.util.Properties;

/**
 * 
 * @Package: com.spring4.learn.poio.collections
 * @ClassName: DataSourceForProperties.java
 *
 * @Description: xml配置学习(applicationContext_collections.xml)
 * 				  配置集合属性 (id = "person6")
 * 
 * 				  使用 <props> 定义 java.util.Properties, 该标签使用多个 <prop> 作为子标签. 每个 <prop> 标签必须定义 key 属性
 * 
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月6日 下午3:39:50
 * @UpdateDate: 2017年2月6日 下午3:39:50
 * @Version: V1.0
 */
public class DataSourceForProperties {
	
	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "DataSourceForProperties [properties=" + properties + "]";
	}
	
	
	
}
