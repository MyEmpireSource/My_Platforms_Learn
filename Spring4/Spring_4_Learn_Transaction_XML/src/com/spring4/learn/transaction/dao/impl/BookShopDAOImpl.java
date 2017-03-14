package com.spring4.learn.transaction.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring4.learn.exception.BookStockException;
import com.spring4.learn.exception.NoRecordException;
import com.spring4.learn.exception.UserAccountException;
import com.spring4.learn.transaction.dao.BookShopDAO;

public class BookShopDAOImpl implements BookShopDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public float findBookPriceByIsbn(String isbn) {
		// TODO Auto-generated method stub
		
		String sqlStr = "SELECT price FROM book WHERE isbn = ?";
		
		try {
			return this.jdbcTemplate.queryForObject(sqlStr, Float.class, isbn);
		} catch (EmptyResultDataAccessException e) {
			throw new NoRecordException("没有符合条件的记录, book : [isbn = " + isbn + "]");
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateBookStock(String isbn) {
		// TODO Auto-generated method stub
		
		// 检查书的库存是否够, 不够则抛出异常
		if (this.findBookStockByIsbn(isbn) <= 0) {
			throw new BookStockException("库存不足, book : [isbn = " + isbn + "]");
		}
		
		String sqlStr = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
		
		try {
			this.jdbcTemplate.update(sqlStr, isbn);
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateUserAccount(String userName, float price) {
		// TODO Auto-generated method stub
		
		// 验证余额是否不足, 若不足则抛出异常
		if (this.findAccountBalanceByUserName(userName) < price) {
			throw new UserAccountException("余额不足, account : [uername = " + userName + "]");
		}
		
		String sqlStr = "UPDATE account SET balance = balance - ? WHERE username = ?";
		
		try {
			this.jdbcTemplate.update(sqlStr, price, userName);
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public int findBookStockByIsbn(String isbn) {
		// TODO Auto-generated method stub
		
		String sqlStr = "SELECT stock FROM book_stock WHERE isbn = ?";
		
		try {
			return this.jdbcTemplate.queryForObject(sqlStr, Integer.class, isbn);
		} catch (EmptyResultDataAccessException e) {
			throw new NoRecordException("没有符合条件的记录, book : [isbn = " + isbn + "]");
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public float findAccountBalanceByUserName(String userName) {
		// TODO Auto-generated method stub
		String sqlStr = "SELECT balance FROM account WHERE username = ?";
		
		try {
			return this.jdbcTemplate.queryForObject(sqlStr, Float.class, userName);
		} catch (EmptyResultDataAccessException e) {
			throw new NoRecordException("没有符合条件的记录, account : [username = " + userName + "]");
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}

}
