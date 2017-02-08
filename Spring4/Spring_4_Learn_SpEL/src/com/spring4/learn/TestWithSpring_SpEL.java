package com.spring4.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.learn.beans.Address;
import com.spring4.learn.beans.CarForSpEL;
import com.spring4.learn.beans.PersonForSpEL;

public class TestWithSpring_SpEL {
	
	public static void main(String[] args) {
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Address address = (Address) cxt.getBean("address_spel");
		System.out.println(address.toString());
		
		CarForSpEL car = (CarForSpEL) cxt.getBean("carForSpEL");
		System.out.println(car.toString());
		
		PersonForSpEL person = (PersonForSpEL) cxt.getBean("personForSpEL");
		System.out.println(person.toString());
		
	}
	
}
