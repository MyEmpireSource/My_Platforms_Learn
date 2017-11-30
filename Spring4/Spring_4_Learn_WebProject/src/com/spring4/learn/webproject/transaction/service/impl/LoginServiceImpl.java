package com.spring4.learn.webproject.transaction.service.impl;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.spring4.learn.webproject.entity.User;
import com.spring4.learn.webproject.transaction.dao.UserDAO;
import com.spring4.learn.webproject.transaction.service.LoginService;
import com.spring4.learn.webproject.util.Constant;
import com.spring4.learn.webproject.util.exception.DBSQLException;
import com.spring4.learn.webproject.util.exception.LogicErrorException;
import com.spring4.learn.webproject.util.exception.WarnException;
import com.spring4.learn.webproject.util.log.LoggerFactory;
import com.spring4.learn.webproject.util.log.ServiceDaoLog;

import net.sf.json.JSONObject;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	private Logger logger = LoggerFactory.getLoggerByName(LoginService.class.getName());
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public String testService(String account, String passwd) {
		// TODO Auto-generated method stub
		
		logger.trace("into LoginService.checkAccount()-trace");
		logger.debug("into LoginService.checkAccount()-debug");
		logger.info("into LoginService.checkAccount()-info");
		logger.warn("into LoginService.checkAccount()-warn");
		logger.error("into LoginService.checkAccount()-error");
		
		System.out.println();
		System.out.println("#######loginService#######");
		System.out.println();
		this.userDAO.testDao(account, passwd);
		
		return null;
	}

	@Override
	public JSONObject checkAccount(String account, String passwd) {
		// TODO Auto-generated method stub
		
		JSONObject json = new JSONObject();
		json.put(Constant.RESULT_KEY, Constant.RESULT_VALUE_FAIL);
		try {
			User user = this.userDAO.queryUserByAccount(account);
			
			logger.info(user.toString());
			if (user.getPassword().equals(passwd)) {
				json.put(Constant.RESULT_KEY, Constant.RESULT_VALUE_SUCCESS);
			} else {
				json.put(Constant.RESULT_INFO_KEY, "登录失败, 账号密码错误!!");
			}
			
		} catch (WarnException ex) {
			logger.warn(ServiceDaoLog.serviceDaoLog("account:" + account + ", passwd:" + passwd, ex.getMessage()));
			json.put(Constant.RESULT_INFO_KEY, "登录失败, 账号密码错误!!");
		} catch (LogicErrorException ex) {
			logger.error(ServiceDaoLog.serviceDaoLog("account:" + account + ", passwd:" + passwd, ex.getMessage()));
			json.put(Constant.RESULT_INFO_KEY, "登录失败, 账号异常!!");
		} catch (DBSQLException ex) {
			logger.error(ServiceDaoLog.serviceDaoLog("account:" + account + ", passwd:" + passwd, "查询出错!!"));
			json.put(Constant.RESULT_INFO_KEY, "登录失败, 查询出错!!");
		} catch (RuntimeException ex) {
			logger.error(ServiceDaoLog.serviceDaoLog("account:" + account + ", passwd:" + passwd, ex.getMessage()));
			json.put(Constant.RESULT_INFO_KEY, "登录失败, 系统出错!!");
		} catch (Exception ex) {
			logger.error(ServiceDaoLog.serviceDaoLog("account:" + account + ", passwd:" + passwd, ex.getMessage()));
			json.put(Constant.RESULT_INFO_KEY, "登录失败, 系统出错!!");
		}
		
		return json;
	}

}
