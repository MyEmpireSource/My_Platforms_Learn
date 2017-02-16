package com.spring4.learn.annotation.repository.impl;

import org.springframework.stereotype.Repository;

import com.spring4.learn.annotation.repository.UserRepositoryOther;

@Repository("userRepositoryOther")
public class UserRepositoryOtherImpl implements UserRepositoryOther {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepositoryOther.save() method ... ...");
	}

}
