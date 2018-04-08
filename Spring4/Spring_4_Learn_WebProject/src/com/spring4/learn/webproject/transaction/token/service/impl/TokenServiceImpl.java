package com.spring4.learn.webproject.transaction.token.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.spring4.learn.webproject.entity.pojo.TokenInfo;
import com.spring4.learn.webproject.transaction.token.service.TokenService;
import com.spring4.learn.webproject.util.Util;
import com.spring4.learn.webproject.util.log.LoggerFactory;
import com.spring4.learn.webproject.util.log.ServiceDaoLog;
import com.spring4.learn.webproject.util.token.JWTTokenOper;
import com.spring4.learn.webproject.util.token.TokenConstant;

import net.sf.json.JSONObject;

@Service("tokenService")
public class TokenServiceImpl implements TokenService {

	private Logger logger = LoggerFactory.getLoggerByName(TokenService.class.getName());

	@Override
	public String getToken(String pkiKey) {
		// TODO Auto-generated method stub
		
		TokenInfo tokenInfo = new TokenInfo();
		tokenInfo.setPkiKey(pkiKey);
		
		return JWTTokenOper.createJWT("JWT", tokenInfo);
	}

	@Override
	public boolean checkTokenInfo(String tokenId) {
		// TODO Auto-generated method stub
		return JWTTokenOper.parseJwt(tokenId);
	}

	@Override
	public String updateExpTimeForTokenId(String tokenId) {
		// TODO Auto-generated method stub
		try {
			String[] tokenInfoArray = tokenId.split("\\.");
			
			JSONObject tokenHeadJson = JWTTokenOper.getTokenHeaderInfoByTokenId(tokenInfoArray[0]);
			
			TokenInfo tokenInfo = JWTTokenOper.getTokenInfoByTokenId(tokenInfoArray[1]);
			
			tokenInfo.setExp(tokenInfo.getExp() + TokenConstant.TOKEN_CHECK_TIME);
			tokenInfo.setAlg(tokenHeadJson.getString("alg"));
			
			return JWTTokenOper.createJWT(tokenHeadJson.getString("typ"), tokenInfo);
		} catch (Exception e) {
			logger.error(ServiceDaoLog.serviceDaoLog("tokenId : " + tokenId, "更新Token有效时间出错!"));
			return null;
		}
		
	}

	@Override
	public Map<String, Object> checkAndReturnToken(JSONObject paramJsonInfo) {
		// TODO Auto-generated method stub
		
		String msg = "";
		Map<String, Object> returnMap = new HashMap<String, Object> ();
		returnMap.put(TokenConstant.TOKEN_CHECK_FLAG_KEY, false);
		
		//if (StringUtil.isNullOrSpace(paramJsonInfoStr)) {
		if (paramJsonInfo == null || paramJsonInfo.isEmpty()) {
			logger.error(ServiceDaoLog.serviceDaoLog("paramJsonInfo : " + paramJsonInfo, "参数信息为空!"));
			msg = "参数信息为空!!";
		} else {
			
			try {
				
				//JSONObject paramJson = JSONObject.fromObject(paramJsonInfoStr);
				// paramJsonInfoStr = {"tokenId":"", .... }
				String tokenId = paramJsonInfo.getString(TokenConstant.TOKEN_INFO_KEY);
				
				if (Util.isNullOrSpaces(tokenId)) {
					logger.warn(ServiceDaoLog.serviceDaoLog("paramJsonInfo : " + paramJsonInfo, "参数中没有Token信息!"));
					msg = "请登录!!";
				} else {
					boolean isTokenIdCheck = this.checkTokenInfo(tokenId);
					
					returnMap.put(TokenConstant.TOKEN_CHECK_FLAG_KEY, isTokenIdCheck);
					
					if (isTokenIdCheck) {
						
						String newTokenId = this.updateExpTimeForTokenId(tokenId);
						
						if (Util.isNullOrSpaces(newTokenId)) {
							logger.error(ServiceDaoLog.serviceDaoLog("oldTokenId : " + tokenId, "生成新的Token出错!"));
							msg = "生成证书失败!!";
						} else {
							returnMap.put(TokenConstant.TOKEN_INFO_KEY, newTokenId);
						}
					} else {
						msg = "证书认证不通过, 请重新登录!!";
					}
				}
				
				
			} catch (Exception e) {
				logger.error(ServiceDaoLog.serviceDaoLog("paramJsonInfo : " + paramJsonInfo, "参数不正确"));
				msg = "参数格式不正确!!";
			}
		}
		
		if (!Util.isNullOrSpaces(msg)) {
			returnMap.put(TokenConstant.TOKEN_CHECK_MESSAGE_KEY, msg);
		}
		
		return returnMap;
		
	}

}
