package com.spring4.learn.webproject.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;


/**
 * 把对象转化为json对象操作
 * 
 * @author 李立
 */
public class ObjectToJson {
	public static final Logger logger = LogManager.getLogger(ObjectToJson.class);
	
	/**
	 * 把对象转化为json字符串；
	 * 
	 * @param objectName 转化为json后的对象key
	 * @param object 待转化的对象
	 * @param excludesAttributeList 对象中不处理的对象数组  eg:[Product, Orders]
	 * @return 转化后的json对象
	 */
	public static JSONObject converObjectToJson(String objectName, Object object, String[] excludesAttributeList){
		ObjectToJson.logger.info("Into converObjectToJson: conver " + object.getClass().getSimpleName() + "[" + objectName + "] to json!");
		try{
			JsonConfig jsonConfig = new JsonConfig();
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put(objectName, object);
			
			//json在解析时, 遇到"对象"属性时跳过解析
			jsonConfig.setExcludes(excludesAttributeList);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			
			JSONObject jsonObject = JSONObject.fromObject(jsonMap, jsonConfig);
			return jsonObject;
		}catch(Exception e){
			ObjectToJson.logger.error("Error in conver " + objectName + " to json", e);
			return null;
		}
	}
	
	/**
	 * 把集合类对象转化为json, 其中有allCount属性记录元素个数 
	 * 
	 * @param objectName 转化为json后的对象key
	 * @param objects 待转化对象
	 * @param excludesAttributeList  对象中不处理的对象数组  eg:[Product, Orders]
	 * @return 转化后的json对象
	 */
	public static JSONObject converCollectionToJson(String objectName, Object objects, String[] excludesAttributeList){
		JSONObject json = converObjectToJson(objectName, objects, excludesAttributeList);
		int count = json.getJSONArray(objectName).size();
		json.put("allCount", count);
		return json;
	}
	
	/**
	 * 把对象转化为Json
	 * 
	 * @param object 待转化对象
	 * @param excludesAttributeList 对象中不处理的对象数组  eg:[Product, Orders]
	 * @return 转化后json对象
	 */
	public static JSON converObjectToJsonWithoutNamae(Object object, String[] excludesAttributeList){
		try{
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(excludesAttributeList);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			
			if(object instanceof Collection || object instanceof List || object instanceof Object[]){
				return JSONArray.fromObject(object, jsonConfig);
			}else{
				return JSONObject.fromObject(object, jsonConfig);
			}
		}catch(Exception e){
			ObjectToJson.logger.error("converObjectToJsonWithoutName Error!! ", e);
			return null;
		}
	}
	
	/**
	 * 
	 * @Title: addInfoToJson
	 * @Description: 向Json对象中加入信息，信息放入Map对象中, 如： {"result" : "error", "info" : "查询失败"}
	 * 
	 * @Params:
	 *   @param json
	 *   @param infoMap 
	 *
	 * @Return: JSON
	 * 
	 * @CreateDate: 2015-12-10 下午3:29:45
	 * @ChangeDate: 2015-12-10 下午3:29:45
	 * @Author: ZCX
	 */
	public static JSON addInfoToJson(JSONObject json, Map<String, String> infoMap) {
		
		if (infoMap == null || infoMap.isEmpty()) {
			return json;
		} else {
			
			for (String key : infoMap.keySet()) {
				json.put(key, infoMap.get(key));
			}
			
			return json;
		}
	}
}