package com.spring4.learn.webproject.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class Util {

	/**
	 * 检查字符串是否是空白字符串或空内容组成，如果是返回true，否则返回false
	 * 
	 * @param str
	 *            检查字符串
	 * @return true or false
	 */
	public static boolean isNullOrSpaces(String str) {
		return str == null || str.trim().equals("");
	}

	/**
	 * 检查字符串是否是数字，如果是返回true，否则返回false
	 * 
	 * @param str
	 *            检查字符串
	 * @return true or false
	 */
	public static boolean isDigit(String str) {
		if (isNullOrSpaces(str)) {
			return false;
		}

		try {
			// 将字符串解析为数字，发生异常时说明字符串不是数字组成。
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 
	 * @Title: getClientIp
	 * @Description: 获取发起请求的客户端的IP
	 * 
	 * @Params:
	 * @param request
	 * @return
	 *
	 * @Return: String
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年3月4日 下午3:20:09
	 * @ChangeDate: 2016年3月4日 下午3:20:09
	 * @Author: 李立
	 */
	public static String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 
	 * @Title: getUUid
	 * @Description: 获取UUID
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: String
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午2:41:06
	 * @ChangeDate: 2018年2月26日 下午2:41:06
	 * @Author: ZCX
	 */
	public static String getUUid() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
}
