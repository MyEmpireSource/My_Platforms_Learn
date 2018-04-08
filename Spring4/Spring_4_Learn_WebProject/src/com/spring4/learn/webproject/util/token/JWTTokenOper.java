package com.spring4.learn.webproject.util.token;

import java.security.Key;
import java.util.Arrays;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.spring4.learn.webproject.entity.pojo.TokenInfo;
import com.spring4.learn.webproject.util.ObjectToJson;
import com.spring4.learn.webproject.util.Util;
import com.spring4.learn.webproject.util.log.ServiceDaoLog;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 * 
 * @Package: com.spring4.learn.webproject.util.token
 * @ClassName: JWTTokenOper.java
 *
 * @Description: JWT 标准的 Token的操作类
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年2月26日 下午2:37:29
 * @UpdateDate: 2018年2月26日 下午2:37:29
 * @Version: V1.0
 */
public class JWTTokenOper {
	
	
	private static Logger logger = LogManager.getLogger(JWTTokenOper.class);
	
	//加密字符串
	private static String SECRET = "";
	
	
	public static String getSecret(String key) {
		
		if (Util.isNullOrSpaces(SECRET)) {
			SECRET = "XX#$%()(#*!()!KL<><PW" + Util.getUUid();
		}
		
		key = Util.isNullOrSpaces(key) ? "" : key;
		//System.out.println(key + SECRET);
		return key + SECRET;
	}
	
	/**
	 * 
	 * @Title: createJWT
	 * @Description: 根据信息创建Token字符串
	 * 				   步骤：
	 * 					 1, 获取 Token 加密算法
	 * 					 2, 获取自定义加密字符 并创建签名
	 * 					 3, 根据 加密算法、签名及Token定义中的payload信息 创建Token标签
	 * 
	 * @Params:
	 *   @param type : Token 的类型, 定义在Head中
	 *   @param payloadTokenInfo : 封装好的用户Token信息及自定义信息 
	 *   @return
	 *
	 * @Return: String : 创建的Token标签(加密的字符串)
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午2:48:13
	 * @ChangeDate: 2018年2月26日 下午2:48:13
	 * @Author: ZCX
	 */
	public static String createJWT(String type, TokenInfo payloadTokenInfo) {
		
		//Token 类型
		type = Util.isNullOrSpaces(type) ? "JWT" : type;
		
		logger.info(ServiceDaoLog.serviceDaoLog("Type : " + type + ", tokenInfo : " + payloadTokenInfo.toString(), "生成Token!!"));
		
		//1, 获取 Token 加密算法
		SignatureAlgorithm signatureAlgorithm = null;

		try {
			signatureAlgorithm = SignatureAlgorithm.forName(payloadTokenInfo.getAlg());
		} catch (Exception  e) {
			logger.error(ServiceDaoLog.serviceDaoLog("TokenInfo.alg : " + payloadTokenInfo.getAlg(), "获取加密算法失败! 重置加密算法!!"));
			signatureAlgorithm = SignatureAlgorithm.HS256;
			payloadTokenInfo.setAlg("HS256");
		}
		
		//2, 获取自定义加密字符 并创建签名
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JWTTokenOper.getSecret(payloadTokenInfo.getPkiKey()));
		//通过加密字符获取签名
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		logger.info(ServiceDaoLog.serviceDaoLog("apiKeySecretBytes : " + Arrays.toString(apiKeySecretBytes), "自定义加密字符"));
		logger.info(ServiceDaoLog.serviceDaoLog("signingKey : " + signingKey, "通过加密字符获取签名字符"));
		
		//3, 根据 加密算法、签名及Token定义中的payload信息 创建Token标签
		try {
			JSON payloadTokenInfoJson = ObjectToJson.converObjectToJsonWithoutNamae(payloadTokenInfo, null);
			//创建Token签名
			JwtBuilder builder = Jwts.builder().setHeaderParam("typ", type).setHeaderParam("alg", payloadTokenInfo.getAlg()).setPayload(payloadTokenInfoJson.toString()).signWith(signatureAlgorithm, signingKey);
			return builder.compact();
			
		} catch (Exception e) {
			logger.error(ServiceDaoLog.serviceDaoLog("生成Token失败：" + e.getMessage()));
			return null;
		}
		//System.out.println(builder);
		//System.out.println(builder.compact());
	}
	
	/**
	 * 
	 * @Title: getTokenInfoByTokenId
	 * @Description: 解析出Token中的payload
	 * 				 	JWT 标准的 Token 有三个部分： header, payload, signature
	 * 					中间用点分隔开, 并且都会使用 Base64 编码  (header.payload.signature)
	 * 					所以真正的 Token 看起来像这样:
	 * 						eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJuaW5naGFvLm5ldCIsImV4cCI6IjE0Mzg5NTU0NDUiLCJuYW1lIjoid2FuZ2hhbyIsImFkbWluIjp0cnVlfQ.SwyHTEx_RQppr97g4J5lKXtabJecpejuef8AqKYMAJc
	 * 
	 * @Params:
	 *   @param payload JWT标准Token中的中间一段加密信息
	 *   @return
	 *
	 * @Return: TokenInfo
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午3:14:16
	 * @ChangeDate: 2018年2月26日 下午3:14:16
	 * @Author: ZCX
	 */
	public static TokenInfo getTokenInfoByTokenId(String payload) {
		
		try {
			JSONObject tokenInfoJson = JSONObject.fromObject(Base64Codec.BASE64URL.decodeToString(payload));
	
			TokenInfo tokenInfo = (TokenInfo) JSONObject.toBean(tokenInfoJson, TokenInfo.class);
			
			return tokenInfo;
		} catch (Exception e) {
			logger.error(ServiceDaoLog.serviceDaoLog("payload : " + payload, "解析出Token中的payload出错 : " + e.getMessage()));
			return null;
		}
	}
	
	
	/**
	 * 
	 * @Title: getTokenHeaderInfoByTokenId
	 * @Description: 解析出Token中的 header
	 * 				 	JWT 标准的 Token 有三个部分： header, payload, signature
	 * 					中间用点分隔开, 并且都会使用 Base64 编码  (header.payload.signature) 
	 * @Params:
	 *   @param tokenHeader JWT标准Token中的第一段加密信息
	 *   @return
	 *
	 * @Return: JSONObject
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午3:21:08
	 * @ChangeDate: 2018年2月26日 下午3:21:08
	 * @Author: ZCX
	 */
	public static JSONObject getTokenHeaderInfoByTokenId(String tokenHeader) {
		
		try {
			JSONObject headerJson = JSONObject.fromObject(Base64Codec.BASE64URL.decodeToString(tokenHeader));
			return headerJson;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @Title: parseJwt
	 * @Description: 验证Token是否合法(是否是自己颁发的)
	 * 				 1, 信息格式正确 
	 * 				 2, 每段信息是否正确(解密过程不会出错)
	 * 				 3, 解析出信息后再次加密所得到的加密信息一样
	 * 				 4, token 在有效期内
	 * 
	 * @Params:
	 *   @param jwt JWT标准的token字符串 (InR5cCI6IkpXVCJ9.eyJpc3MiOiJuaW5naGFvLm5ldCIsImV4cCI6IjE0Mzg5N.SwyHTEx_RQppr97g4J5lKX)
	 *   @return
	 *
	 * @Return: boolean token是否是合法的
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月26日 下午3:23:38
	 * @ChangeDate: 2018年2月26日 下午3:23:38
	 * @Author: ZCX
	 */
	public static boolean parseJwt(String jwt) {
		
		//JWT标准 Token 由三段组成 由 '.'隔开
		String[] jwtArray = jwt.split("\\.");
		
		// 1, 验证格式是否正确
		if(jwtArray.length == 3) {
			String head = jwtArray[0];
			String payload = jwtArray[1];
			
		//	System.out.println(Base64Codec.BASE64URL.decodeToString(head));
		//	System.out.println(Base64Codec.BASE64URL.decodeToString(payload));
			
			logger.info(ServiceDaoLog.serviceDaoLog("Token.Head : " + Base64Codec.BASE64URL.decodeToString(head)));
			logger.info(ServiceDaoLog.serviceDaoLog("Token.Payload : " + Base64Codec.BASE64URL.decodeToString(payload)));
			
			JSONObject headJson = null;
			JSONObject tokenInfoJson = null;
			
			//2, 每段信息是否正确(解密过程不会出错)
			try {
				
				headJson = JSONObject.fromObject(Base64Codec.BASE64URL.decodeToString(head));
				tokenInfoJson = JSONObject.fromObject(Base64Codec.BASE64URL.decodeToString(payload));
			} catch (Exception e) {
				logger.error(ServiceDaoLog.serviceDaoLog("tokenInfo : " + jwt, "解析信息不通过, token非法!"));
				return false;
			}
			
			// 获取Token的签名, 用于与新签名对比
			String sign = jwtArray[2];
			
//			System.out.println(sign);
			logger.info(ServiceDaoLog.serviceDaoLog("Token.Sign : " + sign));
			
/*
			JwsHeader claims1 = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(JWTTokenOper.getSecret(tokenInfoJson.getString("pkiKey")))).parseClaimsJws(jwt).getHeader();
			
			System.out.println(claims1.toString());
*/			
			Map<String, Object> tokenInfoMapObjFromTokenPayload =  null;
			try {
				// 翻译出 Token 的 payload
				tokenInfoMapObjFromTokenPayload = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(JWTTokenOper.getSecret(tokenInfoJson.getString("pkiKey")))).parseClaimsJws(jwt).getBody();
			} catch (Exception e) {
				logger.error(ServiceDaoLog.serviceDaoLog("tokenInfo : " + jwt, "解析tokenInfoMapObj信息不通过, token非法!"));
				// 解密过程出错则表示 该 Token不合法(不是自己颁发的Token或被修改过的)
				return false;
			}
/*			
			for (String s : tokenInfoMapObjFromTokenPayload.keySet()) {
				System.out.println(s + ", " + tokenInfoMapObjFromTokenPayload.get(s));
			}
*/
			// 3, 解析出信息后再次加密所得到的加密信息是否一样
			try {
				
				//解析出的Token.payload
				tokenInfoJson = JSONObject.fromObject(tokenInfoMapObjFromTokenPayload);
			
				TokenInfo tokenInfo = (TokenInfo) JSONObject.toBean(tokenInfoJson, TokenInfo.class);
				
				// 通过解析出的信息再次获取加密信息
				String signNew = JWTTokenOper.createJWT(headJson.getString("typ"), tokenInfo);
				
				// 3, 解析出信息后再次加密所得到的加密信息是否一样
				// 4, token 在有效期内
				if (sign.equals(signNew.split("\\.")[2]) && (System.currentTimeMillis() < tokenInfo.getExp())) {
					return true;
				} else {
					logger.error("token : " + jwt + ", newSign : " + signNew.split("\\.")[2], "签名不匹配!");
					return false;
				}
			} catch (Exception e) {
				logger.error(ServiceDaoLog.serviceDaoLog("生成新签名并对比出错  : " + e.getMessage()));
				return false;
			}
			
		} else {
			logger.error(ServiceDaoLog.serviceDaoLog("tokenInfo : " + jwt, "Token非JWT标准格式"));
			return false;
		}
		 
	}
}
