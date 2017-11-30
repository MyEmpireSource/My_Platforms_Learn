package com.spring4.learn.webproject.transaction.service;

import net.sf.json.JSONObject;

public interface LoginService {
	
	public String testService(String account, String passwd);
	
	public JSONObject checkAccount(String account, String passwd);
	
}
