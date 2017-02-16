package com.spring4.learn.annotation.repository.impl;

import org.springframework.stereotype.Repository;

import com.spring4.learn.annotation.repository.UserRepository;

@Repository("userJdbcRepository")
public class UserJdbcRepositoryImpl implements UserRepository {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserJdbcRepository's save() method ... ...");
	}

}
