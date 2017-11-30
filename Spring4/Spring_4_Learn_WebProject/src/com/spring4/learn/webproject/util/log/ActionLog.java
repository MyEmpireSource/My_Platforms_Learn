package com.spring4.learn.webproject.util.log;

import javax.servlet.http.HttpServletRequest;

/**
 * 设置控制层(Action)的日志信息结构
 * 
 * @author 李立
 */
public class ActionLog {
	/**
	 * 返回不带参数信息的日志信息
	 * 
	 * @param request 请求对象
	 * @param message 信息
	 * @return 日志信息
	 */
	public static String actionLog(HttpServletRequest request, String message){
		return "[Method:" + new Exception().getStackTrace()[1].getMethodName() 
				+ "]-[IP:" + request.getRemoteAddr() + "]-[Info:'" + message +"']";
	}
	
	/**
	 * 返回带参数信息的日志信息
	 * 
	 * @param request 请求对象
	 * @param params 参数信息 , 结构为 paramname:paramvalue, paramname:paramvalue
	 * @param message 信息
	 * @return 日志信息
	 */
	public static String actionLog(HttpServletRequest request, String params, String message){
		return "[Method:" + new Exception().getStackTrace()[1].getMethodName() 
			+ "]-[IP:" + request.getRemoteAddr() + "]-[Params:{" + params + "}]-[Info:'" + message + "']";
	}
}
