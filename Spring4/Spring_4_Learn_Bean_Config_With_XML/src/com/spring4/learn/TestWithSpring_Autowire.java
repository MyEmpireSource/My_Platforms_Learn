package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.poio.autowire.PersonForAutowire;

public class TestWithSpring_Autowire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		PersonForAutowire person9 = (PersonForAutowire) cxt.getBean("person9");
		System.out.println(person9.toString());
		
		PersonForAutowire person10 = (PersonForAutowire) cxt.getBean("person10");
		System.out.println(person10.toString());
		
		PersonForAutowire person11 = (PersonForAutowire) cxt.getBean("person11");
		System.out.println(person11.toString());

	}

}
