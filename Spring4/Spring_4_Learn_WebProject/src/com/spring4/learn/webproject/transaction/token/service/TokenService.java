package com.spring4.learn.webproject.transaction.token.service;

import java.util.Map;

import net.sf.json.JSONObject;

public interface TokenService {
	
	/**
	 * 
	 * @Title: getToken
	 * @Description: 生成 Token
	 * 
	 * @Params:
	 *   @param pkiKey 字符串, 根据不同的字符串(不同客户)生成不同Token
	 *   @return
	 *
	 * @Return: String
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午2:33:37
	 * @ChangeDate: 2018年2月26日 下午2:33:37
	 * @Author: ZCX
	 */
	public String getToken(String pkiKey);
	
	/**
	 * 
	 * @Title: checkTokenInfo
	 * @Description: 验证Token 检查Token是否是合法的(是否是自己颁发的)
	 * 
	 * @Params:
	 *   @param tokenId
	 *   @return
	 *
	 * @Return: boolean
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午2:33:53
	 * @ChangeDate: 2018年2月26日 下午2:33:53
	 * @Author: ZCX
	 */
	public boolean checkTokenInfo(String tokenId);
	
	/**
	 * 
	 * @Title: updateExpTimeForTokenId
	 * @Description: 延长Token的有效时间(若Token有效, 则在访问时延长默认有效长度的时间)
	 * 
	 * @Params:
	 *   @param tokenId
	 *   @return
	 *
	 * @Return: String
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午2:34:08
	 * @ChangeDate: 2018年2月26日 下午2:34:08
	 * @Author: ZCX
	 */
	public String updateExpTimeForTokenId(String tokenId);
	
	
	/**
	 * 
	 * @Title: checkAndReturnToken
	 * @Description: 验证Token, 
	 * 				  若Token验证有效, 则返回新的Token(更新了有效时间的Token)
	 * 				  若Token验证无效, 则返回提示信息
	 * 
	 * @Params:
	 *   @param paramJsonInfoStr {"tokenId":"", .... }
	 *   @return
	 *
	 * @Return: Map<String,Object> = {"isRight":"true", "tokenId":""} | {"isRight":"false", "msg":""}
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午2:34:39
	 * @ChangeDate: 2018年2月26日 下午2:34:39
	 * @Author: ZCX
	 */
	public Map<String, Object> checkAndReturnToken(JSONObject paramJsonInfo);
	
}
