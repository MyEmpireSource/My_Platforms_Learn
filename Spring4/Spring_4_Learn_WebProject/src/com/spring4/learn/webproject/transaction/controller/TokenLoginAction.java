package com.spring4.learn.webproject.transaction.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring4.learn.webproject.transaction.token.service.TokenResponseFormatService;
import com.spring4.learn.webproject.transaction.token.service.TokenService;
import com.spring4.learn.webproject.util.Util;
import com.spring4.learn.webproject.util.token.TokenConstant;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/token")
public class TokenLoginAction {
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private TokenResponseFormatService tokenResponseFormatService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response, @RequestBody String userJsonInfoStr) {
		
		JSONObject json = null;
		String msg = "";
		String tokenStr = "";
		String xtRyId = "";
		
		if (Util.isNullOrSpaces(userJsonInfoStr)) {
			msg = "参数信息为空!!";
		} else {
			try {
				JSONObject userJson = JSONObject.fromObject(userJsonInfoStr);
				
				String pki = userJson.getString("pki");
				
				if (Util.isNullOrSpaces(pki)) {
					msg = "用户信息为空!!";
				} else {
					tokenStr = this.tokenService.getToken(pki);
				}
				
			} catch (Exception e) {
				msg = "参数格式不正确!!";
			}
			
			if (Util.isNullOrSpaces(msg)) {
				
				/*
				json.put(Constant.MOBILE_CODE_KEY, Constant.MOBILE_CODE_SUCCESS);
				json.put(Constant.MOBILE_MESSAGE_KEY, "登录成功!!");
				
				//JSONObject dataJson = new JSONObject();
				xtRyJson.put(Constant.MOBILE_TOKEN_KEY, tokenStr);
				
				json.put(Constant.MOBILE_DATA_KEY, xtRyJson);
				*/
				
				Map<String, Object> headMap = new HashMap<String, Object>();
				headMap.put(TokenConstant.TOKEN_CHECK_CODE_KEY, TokenConstant.TOKEN_CHECK_CODE_SUCCESS);
				headMap.put(TokenConstant.TOKEN_CHECK_MESSAGE_KEY, "登录成功!!");
				headMap.put(TokenConstant.TOKEN_INFO_KEY, tokenStr);
				headMap.put("ryId", xtRyId);
				
				json = this.tokenResponseFormatService.createHeadReturnJsonInfo(headMap);
				
			} else {
				json = this.tokenResponseFormatService.createHeadReturnJsonInfo(TokenConstant.TOKEN_CHECK_CODE_FAIL, msg);
			}
			
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().println(json.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
