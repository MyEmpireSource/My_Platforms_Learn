package com.spring4.learn.webproject.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BeanAttribute {
	private static final Logger logger = LogManager.getLogger(BeanAttribute.class);
	
	/**
	 * 根据属性修饰类型(public,private...)得到类的属性数组
	 * 
	 * @param className 类的完整名称
	 * @param attrPermissions 类修饰
	 * @return 类的属性数组
	 */
	@SuppressWarnings("finally")
	private static Field[] getBeanAttributes(String className, int attrPermissions){
		Field[] fields = null;
		try {
			Class cls = Class.forName(className);
			if(attrPermissions == State.ALL_PUBLIC_TYPE){
				//包含所有有继承和接口里的公有属性
				fields = cls.getFields();
				BeanAttribute.logger.info("Get " + className + "'s all public type attributes!");
			}else if(attrPermissions == State.ALL_TYPE){
				//包含所有接口里的公有,私有和受保护属性
				fields = cls.getDeclaredFields();
				BeanAttribute.logger.info("Get " + className + "'s all type attributes!");
			}else{
				Field[] allFields = cls.getDeclaredFields();
				ArrayList<Field> fieldList = new ArrayList<Field>();
				for(Field f : allFields){
					if(f.getModifiers() == attrPermissions){
						fieldList.add(f);
					}
				}
				fields = (Field[])fieldList.toArray(new Field[fieldList.size()]);
				BeanAttribute.logger.info("Get the modifier is " + attrPermissions + "'s attributes of " + className + "!");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			BeanAttribute.logger.error("Get " + className + " attributes Error: params: [attrPermissions - +"+attrPermissions+"]", e);
			//e.printStackTrace();
		}finally{
			return fields;
		}
	}
	
	/**
	 * 根据属性类型和属性修饰获得类中属性的类型数组
	 * 
	 * @param className 类名称
	 * @param attrPermissions 修饰类型
	 * @param attType属性类型, 为空或null则返回符合类型修饰的属性数组
	 * @return 属性的类型数组
	 */
	public static String[] getBeanAttributesByType(String className, int attrPermissions, String attType){
		Field[] fields = getBeanAttributes(className, attrPermissions);
		if(Util.isNullOrSpaces(attType)){
			String[] attributes = new String[fields.length];
			for(int i = 0; i < fields.length; i++){
				attributes[i] = fields[i].getName();
			}
			return attributes;
		}else{
			ArrayList<String> attributes = new ArrayList<String>();
			for(Field f : fields){
				if(f.getType().getName().equals(attType)){
					//属性相同
					attributes.add(f.getName());
				}
			}
			return (String[]) attributes.toArray(new String[attributes.size()]);
		}
	}
	
	/**
	 * 把类中满足类型和修饰类型的属性中排除例外的属性以数组形式返回
	 * 
	 * @param className 类名
	 * @param attrPermissions 修饰类型
	 * @param exceptAttribute 类外的类型数组
	 * @return 属性数组
	 */
	public static String[] getBeanAttributesByExceptList(String className, int attrPermissions, String[] exceptAttribute){
		Field[] fields = getBeanAttributes(className, attrPermissions);
		Arrays.sort(exceptAttribute);
		ArrayList<String> attributes = new ArrayList<String>();
		for(Field f : fields){
			if(Arrays.binarySearch(exceptAttribute, f.getName()) < 0){
				//没在例外中, 加入返回列表
				attributes.add(f.getName());
			}
		}
		return (String[]) attributes.toArray(new String[attributes.size()]);
	}
}
