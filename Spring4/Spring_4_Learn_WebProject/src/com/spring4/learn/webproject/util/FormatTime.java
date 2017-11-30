package com.spring4.learn.webproject.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化输出类
 * 
 * @author 李立
 */
public class FormatTime {
	public static final SimpleDateFormat TIME_FMT = new SimpleDateFormat("HH:mm:ss");
	public static final SimpleDateFormat DATE_FMT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat DATETIME_FMT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 返回Date对象按(yyyy-MM-dd HH:mm:ss)的格式化时间字符串
	 * 
	 * @param date
	 *            Date对象
	 * 
	 * @return 格式化时间字符串
	 */
	public static String getFormatDateTime(Date date) {
		return FormatTime.DATETIME_FMT.format(date);
	}

	/**
	 * 返回Date对象按(yyyy-MM-dd)的格式化时间字符串
	 * 
	 * @param date
	 *            Date对象
	 * 
	 * @return 格式化时间字符串
	 */
	public static String getFormatDate(Date date) {
		return FormatTime.DATE_FMT.format(date);
	}

	/**
	 * 返回Date对象按(HH:mm:ss)的格式化时间字符串
	 * 
	 * @param date
	 *            Date对象
	 * 
	 * @return 格式化时间字符串
	 */
	public static String getFormatTime(Date date) {
		return FormatTime.TIME_FMT.format(date);
	}
}
