package com.spring4.learn.webproject.transaction.token.service;

import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 
 * @Package: com.spring4.learn.webproject.transaction.token.service
 * @ClassName: TokenResponseFormatService.java
 *
 * @Description: 为token验证的Action返回封装好的格式化数据的服务类
 * 
 * 				 {
 * 					"head" : {"code" : 0, "msg":""} 
 * 				 }
 * 				 或
 * 				 {
 * 					"head" : {"code" : 1, "tokenId":""},
 * 					"data" : {业务逻辑返回的json格式数据} 
 * 				 } 
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年2月26日 下午5:06:47
 * @UpdateDate: 2018年2月26日 下午5:06:47
 * @Version: V1.0
 */
public interface TokenResponseFormatService {
	
	/**
	 * 
	 * @Title: createHeadReturnJsonInfo
	 * @Description: 返回一个格式化好的JSON对象, 同时设置 head对象的 code 及 message
	 * 
	 * @Params:
	 *   @param code
	 *   @param message
	 *   @return
	 *
	 * @Return: JSONObject
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午5:21:58
	 * @ChangeDate: 2018年2月26日 下午5:21:58
	 * @Author: ZCX
	 */
	public JSONObject createHeadReturnJsonInfo(int code, String message);
	
	/**
	 * 
	 * @Title: createHeadReturnJsonInfo
	 * @Description: 创建 返回 head 的JSON格式数据
	 * 
	 * @Params:
	 *   @param headInfoMap
	 *   @return
	 *
	 * @Return: JSONObject
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午5:23:05
	 * @ChangeDate: 2018年2月26日 下午5:23:05
	 * @Author: ZCX
	 */
	public JSONObject createHeadReturnJsonInfo(Map<String, Object> headInfoMap);
	
	/**
	 * 
	 * @Title: createDataReturnJsonInfo
	 * @Description: 创建 返回 data 的JSON格式数据
	 * 
	 * @Params:
	 *   @param dataInfoMap
	 *   @return
	 *
	 * @Return: JSONObject
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午5:23:54
	 * @ChangeDate: 2018年2月26日 下午5:23:54
	 * @Author: ZCX
	 */
	public JSONObject createDataReturnJsonInfo(Map<String, Object> dataInfoMap);
	
	public JSONObject createReturnJsonInfo(Map<String, Object> headInfoMap, Map<String, Object> dataInfoMap);
	
	/**
	 * 
	 * @Title: addVarIntoAppResponseJsonInfo
	 * @Description: 向返回的JSON对象中添加 head 或 data 属性
	 * 
	 * @Params:
	 *   @param infoJson 返回的Json对象 
	 *   @param headVarName
	 *   @param headVar
	 *   @param dataVarName
	 *   @param dataVar
	 *   @return
	 *
	 * @Return: JSONObject
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午5:24:20
	 * @ChangeDate: 2018年2月26日 下午5:24:20
	 * @Author: ZCX
	 */
	public JSONObject addVarIntoAppResponseJsonInfo(JSONObject infoJson, String headVarName, Object headVar, String dataVarName, Object dataVar);
	
}
