package com.spring4.learn.webproject.entity.pojo;

import java.util.HashMap;
import java.util.Map;

import com.spring4.learn.webproject.util.token.TokenConstant;

/**
 * 
 * @Package: com.spring4.learn.webproject.entity.pojo
 * @ClassName: TokenResponseObj.java
 *
 * @Description: 支持Token验证的服务返回的数据结构抽象对象类, 
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
 * @CreateDate: 2018年2月26日 下午5:14:59
 * @UpdateDate: 2018年2月26日 下午5:14:59
 * @Version: V1.0
 */
public class TokenResponseObj {
	
	private Map<String, Object> head = new HashMap<String, Object>() {
		{
			put(TokenConstant.TOKEN_CHECK_CODE_KEY, 1);
			put(TokenConstant.TOKEN_INFO_KEY, "");
		}
	};
	
	private Map<String, Object> data = new HashMap<String, Object>();

	public Map<String, Object> getHead() {
		return head;
	}

	public void setHead(Map<String, Object> head) {
		this.head = head;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public void setHeadInfo(String name, Object value) {
		this.head.put(name, value);
	}
	
	public void setDataInfo(String name, Object value) {
		this.data.put(name, value);
	}
}
