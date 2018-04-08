package com.spring4.learn.webproject.transaction.aop.aspect;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring4.learn.webproject.transaction.token.service.TokenResponseFormatService;
import com.spring4.learn.webproject.transaction.token.service.TokenService;
import com.spring4.learn.webproject.util.log.ServiceDaoLog;
import com.spring4.learn.webproject.util.token.TokenConstant;

import net.sf.json.JSONObject;

/**
 * 
 * @Package: com.spring4.learn.webproject.transaction.aop.aspect
 * @ClassName: TokenVlidationAspect.java
 *
 * @Description: 验证Token的AOP切面
 * 				   该切面的方法 针对的请求 是参数 保存在 body中 , 相应方法由多个参数, 发送回的数据为第三个参数的请求
 * 				   具体看 "关于TokenVlidationAspect的解释.png"
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年2月26日 下午4:58:24
 * @UpdateDate: 2018年2月26日 下午4:58:24
 * @Version: V1.0
 */

@Component
@Aspect
public class TokenVlidationAspect {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private TokenResponseFormatService tokenResponseFormatService;
	
	//@Pointcut("execution (* com.spring4.learn.webproject.transaction.controller.token.TokenNeedOperaterAction.*(..))")
	//@Pointcut("execution (* com.spring4.learn.webproject.transaction.controller.token.TokenNeed*.*(..))")
	@Pointcut("execution (* com.spring4.learn.webproject.transaction.controller.token.*.*(..))")
	public void declareJointPoinExpressionForToken(){}
	
	@Around("declareJointPoinExpressionForToken()")
	public void checkTokenInfo(ProceedingJoinPoint proJoinPoint) throws Throwable {
		
		Logger logger = LogManager.getLogger(proJoinPoint.getSignature().getDeclaringType());
		String methdoName = proJoinPoint.getSignature().getName();
		
		int code = TokenConstant.TOKEN_CHECK_CODE_FAIL;
		String msg = "";
		
		// 获取参数
		Object[] args = proJoinPoint.getArgs();
		boolean isError = false;
		if (args.length < 3) {
			logger.error(ServiceDaoLog.serviceDaoLogWithMethod(methdoName, "方法参数格式不对"));
			msg = "方法参数格式不对!!";
			isError = true;
		} else {
			
			JSONObject paramJson = null;
			try {
				paramJson = JSONObject.fromObject(args[2]);
			} catch (Exception e) {
				msg = "参数格式不正确!!";
				logger.error(ServiceDaoLog.serviceDaoLogWithMethod(methdoName, "参数格式不正确!!"));
				isError = true;
			}
			
			if (!isError) {
				Map<String, Object> checkReturnMap = this.tokenService.checkAndReturnToken(paramJson);
				
				if ((boolean) checkReturnMap.get(TokenConstant.TOKEN_CHECK_FLAG_KEY)) {
					
					// 修改参数, 把参数中 tokenId的值更新
					paramJson.put(TokenConstant.TOKEN_INFO_KEY, checkReturnMap.get(TokenConstant.TOKEN_INFO_KEY));
					
					args[2] = paramJson.toString();
					
					try {
						proJoinPoint.proceed(args);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						logger.error(ServiceDaoLog.serviceDaoLogWithMethod(methdoName, "设置参数出错!!"));
						throw e;
					}
					
				} else {
					code = TokenConstant.ERROR_CODE_SC_UNAUTHORIZED;
					msg = "验证信息不正确!!";
					logger.error(ServiceDaoLog.serviceDaoLogWithMethod(methdoName, "验证信息不正确!!"));
					isError = true;
				}
			}
		}
		
		if (isError) {
			try {
				HttpServletResponse response = (HttpServletResponse) args[1];
				
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().println(this.tokenResponseFormatService.createHeadReturnJsonInfo(code, msg));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(ServiceDaoLog.serviceDaoLog(e.getMessage()));
			}
		}
	}
	
	/**
	 * 
	 * @Title: afterMethodThrowing
	 * @Description: 发生异常后统一返回数据给调用者
	 * 
	 * @Params:
	 *   @param joinPoint
	 *   @param ex
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年2月27日 下午4:11:20
	 * @ChangeDate: 2018年2月27日 下午4:11:20
	 * @Author: ZCX
	 */
	@AfterThrowing(value="com.spring4.learn.webproject.transaction.aop.aspect.AspectPointcut.declareJointPoinExpressionForToken()", throwing = "ex")
	public void afterMethodThrowing(JoinPoint joinPoint, Exception ex) {
		Logger logger = LogManager.getLogger(joinPoint.getSignature().getDeclaringType());
		String methdoName = joinPoint.getSignature().getName();
		
		//参数
		Object[] args = joinPoint.getArgs();
		
		try {
			
			logger.error(ServiceDaoLog.serviceDaoLogWithMethod(methdoName, ex.getMessage()));
			HttpServletResponse response = (HttpServletResponse) args[1];
			
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(this.tokenResponseFormatService.createHeadReturnJsonInfo(TokenConstant.TOKEN_CHECK_CODE_FAIL, "执行出错!!"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(ServiceDaoLog.serviceDaoLog(e.getMessage()));
		}
		
	}
}
