package com.spring4.learn.webproject.util;

import java.lang.reflect.Modifier;

/**
 * 通用状态设置类, 设置系统内通用的状态
 * 
 * @author 李立
 *
 */
public class State {

	public static final int PUBLIC_TYPE = Modifier.PUBLIC;
	public static final int PRIVATE_TYPE = Modifier.PRIVATE;
	public static final int PROTECTED_TYPE = Modifier.PROTECTED;
	public static final int STATIC_TYPE = Modifier.STATIC;
	public static final int FINAL_TYPE = Modifier.FINAL;
	public static final int ALL_TYPE = -1;
	public static final int ALL_PUBLIC_TYPE = -2;

}
