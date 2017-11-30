package com.spring4.learn.webproject.util.log;

/**
 * 设置Service和DAO的日志信息结构
 * 
 * @author 李立
 */
public class ServiceDaoLog {
	
	/**
	 * 返回带参数的日志信息
	 * @param params 参数, 结构为 paramname:paramvalue, paramname:paramvalue
	 * @param message 信息
	 * @return 日志信息
	 */
	public static String serviceDaoLog(String params, String message){
		return "[Method:" + new Exception().getStackTrace()[1].getMethodName() 
				+ "]-[Params:{" + params + "}]-[Info:'" + message + "']";
	}
	
	/**
	 * 返回不带参数信息的日志信息
	 * @param message 信息
	 * @return 日志信息
	 */
	public static String serviceDaoLog(String message){
		return "[Method:" + new Exception().getStackTrace()[1].getMethodName() + "]-[Info:'" + message + "']";
	}
	
	public static void main(String[] args){
		System.out.println(serviceDaoLog("name:LILI, age:18", "Add user LILI!"));
		System.out.println(serviceDaoLog("Get LILI info Success!"));
	}
}