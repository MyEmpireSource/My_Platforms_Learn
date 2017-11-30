package com.spring4.learn.webproject.transaction.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring4.learn.webproject.transaction.service.LoginService;
import com.spring4.learn.webproject.util.log.LoggerFactory;

@Controller
@RequestMapping("/systemManager")
public class LoginAction {
	
	private Logger logger = LoggerFactory.getLoggerByName(LoginAction.class.getName());
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		logger.trace("into LoginAction.loginAction()-trace");
		logger.debug("into LoginAction.loginAction()-debug");
		logger.info("into LoginAction.loginAction()-info");
		logger.warn("into LoginAction.loginAction()-warn");
		logger.error("into LoginAction.loginAction()-error");
		
		System.out.println("-------------");
		
		System.out.println(request.toString());
		
		System.out.println(response.toString());
		
		this.loginService.testService("TT", "FF");
		
		System.out.println("-------------");
		
		return "showOperate";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String account = request.getParameter("account");
		
		String passwd = request.getParameter("passwd");
		
		this.loginService.checkAccount(account, passwd);
		return "showOperate";
		
	}
	
	
	
}
