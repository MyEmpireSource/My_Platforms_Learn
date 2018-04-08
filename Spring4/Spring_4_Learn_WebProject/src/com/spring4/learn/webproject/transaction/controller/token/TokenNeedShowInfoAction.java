package com.spring4.learn.webproject.transaction.controller.token;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring4.learn.webproject.transaction.token.service.TokenResponseFormatService;
import com.spring4.learn.webproject.util.token.TokenConstant;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/token/test")
public class TokenNeedShowInfoAction {
	
	@Autowired
	private TokenResponseFormatService tokenResponseFormatService;
	
	@RequestMapping(value = "/testPointcutExecution", method = RequestMethod.POST)
	public void testPointcutExecution(HttpServletRequest request, HttpServletResponse response, @RequestBody String paramJsonInfoStr) throws IOException {
		
		JSONObject json = JSONObject.fromObject(paramJsonInfoStr);
		
		JSONObject returnJson = this.tokenResponseFormatService.createHeadReturnJsonInfo(TokenConstant.TOKEN_CHECK_CODE_SUCCESS, "OK");
		this.tokenResponseFormatService.addVarIntoAppResponseJsonInfo(returnJson, TokenConstant.TOKEN_INFO_KEY, json.getString(TokenConstant.TOKEN_INFO_KEY), "timeKet", System.currentTimeMillis());
		
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println(returnJson.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
	}
	
}
