package com.spring4.learn.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService <T> {
	
	//此注解会被子类继承
	@Autowired
	protected BaseRepository<T> repository;
	
	public void add(T t) {
		System.out.println("BaseService.add() method ... ...");
		repository.save(t);
		System.out.println(repository);
	}
}
