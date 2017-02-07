package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.poio.relation.AddressForRelation;
import com.spring4.learn.poio.relation.PersonForRelation;

/**
 * 
 * @Package: com.spring4.learn
 * @ClassName: TestWithSpring_Relation.java
 *
 * @Description: Spring Bean之间的配置关系 配置
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月7日 下午2:42:34
 * @UpdateDate: 2017年2月7日 下午2:42:34
 * @Version: V1.0
 */
public class TestWithSpring_Relation {
	
	public static void main(String[] args){
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext_bean_relation.xml");
		
		AddressForRelation address = (AddressForRelation) cxt.getBean("address_relation_1");
		System.out.println(address.toString());
		
		address = (AddressForRelation) cxt.getBean("address_relation_2");
		System.out.println(address.toString());
		
		address = (AddressForRelation) cxt.getBean("address_relation_3");
		System.out.println(address.toString());
		
		address = (AddressForRelation) cxt.getBean("address_relation_4");
		System.out.println(address.toString());
		
		address = (AddressForRelation) cxt.getBean("address_relation_5");
		System.out.println(address.toString());
		
		PersonForRelation person = (PersonForRelation) cxt.getBean("persion_relation");
		System.out.println(person.toString());
		
		
	}
	
}
