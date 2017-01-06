package com.spring4.learn.poio;

/**
 * 
 * @Package: com.spring4.learn.poio
 * @ClassName: HelloWorld.java
 *
 * @Description: xml配置学习(applicationContext.xml)
 * 				  学习 Spring Bean的配置及属性注入(id="helloWorld")
 * 
 * @Company:
 * @Author: 李立  
 * @CreateDate: 2016年7月25日 下午8:22:18
 * @UpdateDate: 2016年7月25日 下午8:22:18
 * @Version: V1.0
 */
public class HelloWorld {
	
	private String info;

	public void setInfo2(String info) {
		System.out.println("Set method : set info : " + info);
		this.info = info;
	}
	
	public void sayHello() {
		System.out.println("Hello : " + this.info);
	}
	
	public HelloWorld() {
		System.out.println("HelloWorld's Constructor...");
	}
	
}
