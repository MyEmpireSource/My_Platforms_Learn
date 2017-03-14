package com.spring4.learn.transaction.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring4.learn.transaction.dao.AccountDAO;

public class AccountDAOImpl implements AccountDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void addAccount(String userName, float balance) {
		// TODO Auto-generated method stub
		
		String sqlStr = "INSERT INTO account(username, balance) VALUES(?, ?)";
		
		this.jdbcTemplate.update(sqlStr, userName, balance);
	}

}
