package com.spring4.learn;

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
