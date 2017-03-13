package com.spring4.learn.transaction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring4.learn.transaction.dao.AccountDAO;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addAccount(String userName, float balance) {
		// TODO Auto-generated method stub
		
		String sqlStr = "INSERT INTO account(username, balance) VALUES(?, ?)";
		
		this.jdbcTemplate.update(sqlStr, userName, balance);
	}

}
