package com.spring4.learn.annotation.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring4.learn.annotation.bean.TestObjectNotInIOC;
import com.spring4.learn.annotation.repository.UserRepository;

@Repository(value="userRepository")
public class UserRepositoryImpl implements UserRepository {
	
	// 默认情况下, 所有使用 @Authwired 注解的属性都需要被设置. 当 Spring 找不到匹配的 Bean 装配属性时, 
	// 会抛出异常, 若某一属性允许不被设置, 可以设置 @Authwired 注解的 required 属性为 false
	@Autowired(required=false)
	private TestObjectNotInIOC testObject;
	

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository's save() method ... ...");
		System.out.println(testObject);
	}

}
