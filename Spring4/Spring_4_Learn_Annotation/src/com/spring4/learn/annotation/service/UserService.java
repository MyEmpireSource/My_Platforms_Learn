package com.spring4.learn.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring4.learn.annotation.repository.UserRepository;
import com.spring4.learn.annotation.repository.impl.UserRepositoryOtherImpl;

@Service
public class UserService {
	
	//默认去查找有没有一个Bean和属性名称一致
	@Autowired
	private UserRepository userRepository;
	
	// 默认去查找有没有一个Bean和属性名称一致, 没有则通过类型匹配, 
	// 找到唯一匹配的类型Bean后, 注入该类型
	@Autowired
	private UserRepositoryOtherImpl userRepositoryOtherTest;
	
	//没有一个Bean和属性名称一致, 匹配类型有多个, 不能确定唯一时, 有多个则通过@Qualifier指定
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepositoryOther;
	
	//通过 Set方法注入
	private UserRepository userJdbcRepository;
	
	//构造器, 普通字段(即使是非 public), 一切具有参数的方法都可以应用@Authwired 注解
	@Autowired
	@Qualifier("userJdbcRepository")
	public void setUserJdbcRepository(UserRepository userJdbcRepository) {
		this.userJdbcRepository = userJdbcRepository;
	}
	
	/*
	// @Qualifier可以加到入参那里
	@Autowired 
	public void setUserJdbcRepository(@Qualifier("userJdbcRepository") UserRepository userJdbcRepository) {
		this.userJdbcRepository = userJdbcRepository;
	}
	*/
	
	
	public void add() {
		System.out.println("UserService.add() method ... ...");
		this.userRepository.save();
		this.userRepositoryOther.save();
		this.userJdbcRepository.save();
		this.userRepositoryOtherTest.save();
	}
	
}
