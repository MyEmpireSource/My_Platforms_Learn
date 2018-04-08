package com.spring4.learn.webproject.entity.pojo;

/**
 * 
 * @Package: com.spring4.learn.webproject.entity.pojo
 * @ClassName: TokenInfo.java
 *
 * @Description: JWT 标准的 Token 自定义封装属性
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年2月26日 上午11:48:09
 * @UpdateDate: 2018年2月26日 上午11:48:09
 * @Version: V1.0
 */
public class TokenInfo {
	
	private String aud = "mobile";
	private String iss = "Spring_4_Learn_WebProject";
	private long iat = System.currentTimeMillis();
	private long exp = this.iat + 3600000;
	
	
	private String userId;
	private String alg = "HS256";
	
	//用户标识
	private String pkiKey = "";

	public String getAud() {
		return aud;
	}

	public void setAud(String aud) {
		this.aud = aud;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public long getIat() {
		return iat;
	}

	public void setIat(long iat) {
		this.iat = iat;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAlg() {
		return alg;
	}

	public void setAlg(String alg) {
		this.alg = alg;
	}

	public String getPkiKey() {
		return pkiKey;
	}

	public void setPkiKey(String pkiKey) {
		this.pkiKey = pkiKey;
	}
	
	
	
}
