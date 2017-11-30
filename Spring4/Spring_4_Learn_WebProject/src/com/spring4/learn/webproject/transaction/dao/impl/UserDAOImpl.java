package com.spring4.learn.webproject.transaction.dao.impl;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring4.learn.webproject.entity.User;
import com.spring4.learn.webproject.transaction.dao.UserDAO;
import com.spring4.learn.webproject.util.exception.DBSQLException;
import com.spring4.learn.webproject.util.exception.LogicErrorException;
import com.spring4.learn.webproject.util.exception.WarnException;
import com.spring4.learn.webproject.util.log.LoggerFactory;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	private Logger logger = LoggerFactory.getLoggerByName(UserDAO.class.getName());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String testDao(String account, String passwd) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println(".........userDAO........");
		System.out.println();
		
		logger.trace("into UserDAO.userLogin()-trace");
		logger.debug("into UserDAO.userLogin()-debug");
		logger.info("into UserDAO.userLogin()-info");
		logger.warn("into UserDAO.userLogin()-warn");
		logger.error("into UserDAO.userLogin()-error");
		
		return null;
	}
	

	@Override
	public User queryUserByAccount(String account) {
		// TODO Auto-generated method stub
		
		String sqlStr = "SELECT * FROM user WHERE account_name = ?";
		
		try {
			return this.jdbcTemplate.queryForObject(sqlStr, new Object[] {account}, new BeanPropertyRowMapper<User>(User.class));
		} catch (EmptyResultDataAccessException ex) {
			throw new WarnException("没有记录!!", ex);
		} catch (IncorrectResultSizeDataAccessException ex) {
			throw new LogicErrorException("有多条记录, 与逻辑不符!!", ex);
		} catch (BadSqlGrammarException ex) {
			throw new DBSQLException("SQL 语句语法错误 : " + sqlStr, ex);
		} catch (Exception ex) {
			throw new RuntimeException("查询异常", ex);
		}
		
	}

}
