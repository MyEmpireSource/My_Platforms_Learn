package com.spring4.learn.webproject.transaction.token.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring4.learn.webproject.entity.pojo.TokenResponseObj;
import com.spring4.learn.webproject.transaction.token.service.TokenResponseFormatService;
import com.spring4.learn.webproject.util.ObjectToJson;
import com.spring4.learn.webproject.util.Util;
import com.spring4.learn.webproject.util.token.TokenConstant;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

@Service("appResponseFormatService")
public class TokenResponseFormatServiceImpl implements TokenResponseFormatService {

	private JSONObject returnAppResponseJsonInfo(TokenResponseObj tokenResponseObj) {
		JSON returnJson = ObjectToJson.converObjectToJsonWithoutNamae(tokenResponseObj, null);
		return returnJson == null ? null : (JSONObject) returnJson;
	}
	
	@Override
	public JSONObject createHeadReturnJsonInfo(int code, String message) {
		// TODO Auto-generated method stub
		TokenResponseObj tokenResponseObj = new TokenResponseObj();
		
		tokenResponseObj.setHeadInfo(TokenConstant.TOKEN_CHECK_CODE_KEY, code);
		tokenResponseObj.setHeadInfo(TokenConstant.TOKEN_CHECK_MESSAGE_KEY, message);
		
		return this.returnAppResponseJsonInfo(tokenResponseObj);
	}

	@Override
	public JSONObject createHeadReturnJsonInfo(Map<String, Object> headInfoMap) {
		// TODO Auto-generated method stub
		return this.createReturnJsonInfo(headInfoMap, null);
	}

	@Override
	public JSONObject createDataReturnJsonInfo(Map<String, Object> dataInfoMap) {
		// TODO Auto-generated method stub
		return this.createReturnJsonInfo(null, dataInfoMap);
	}

	@Override
	public JSONObject createReturnJsonInfo(Map<String, Object> headInfoMap, Map<String, Object> dataInfoMap) {
		// TODO Auto-generated method stub
		TokenResponseObj tokenResponseObj = new TokenResponseObj();
		
		if (headInfoMap != null && !headInfoMap.isEmpty()) {
			for (String key : headInfoMap.keySet()) {
				tokenResponseObj.setHeadInfo(key, headInfoMap.get(key));
			}
		}
		
		if (dataInfoMap != null && !dataInfoMap.isEmpty()) {
			for (String key : dataInfoMap.keySet()) {
				tokenResponseObj.setDataInfo(key, dataInfoMap.get(key));
			}
		}
		
		return this.returnAppResponseJsonInfo(tokenResponseObj);
	}

	@Override
	public JSONObject addVarIntoAppResponseJsonInfo(JSONObject infoJson, String headVarName, Object headVar,
			String dataVarName, Object dataVar) {
		// TODO Auto-generated method stub
		if (Util.isNullOrSpaces(headVarName) && Util.isNullOrSpaces(dataVarName)) {
			return infoJson;
		} else {
			
			//System.out.println(infoJson.isNullObject());
			//System.out.println(infoJson.isEmpty());
			
			if (infoJson == null || infoJson.isEmpty()) {
				TokenResponseObj responseObj = new TokenResponseObj();
				
				if (!Util.isNullOrSpaces(headVarName) && headVar != null) {
					responseObj.setHeadInfo(headVarName, headVar);
				}
				if (!Util.isNullOrSpaces(dataVarName) && dataVar != null) {
					responseObj.setDataInfo(dataVarName, dataVar);
				}
				
				return this.returnAppResponseJsonInfo(responseObj);
			} else {
				
				if (!Util.isNullOrSpaces(headVarName) && headVar != null) {
					JSONObject headJson = infoJson.getJSONObject(TokenConstant.TOKEN_HEAD_KEY);
					
					if (headJson.isNullObject()) {
						headJson = new JSONObject();
					}
					
					headJson.put(headVarName, headVar);
					infoJson.put(TokenConstant.TOKEN_HEAD_KEY, headJson);
				}
				
				if (!Util.isNullOrSpaces(dataVarName) && dataVar != null) {
				
					JSONObject dataJson = infoJson.getJSONObject(TokenConstant.TOKEN_DATA_KEY);
					
					if (dataJson.isNullObject()) {
						dataJson = new JSONObject();
					}
					
					dataJson.put(dataVarName, dataVar);
					infoJson.put(TokenConstant.TOKEN_DATA_KEY, dataJson);
				}
				
				return infoJson;
			}
		}
	}

}
