package com.spring4.learn.webproject.transaction.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring4.learn.webproject.util.log.LoggerFactory;

public class SessionFilter extends OncePerRequestFilter {
	
	private static Logger logger = LoggerFactory.getLoggerByName(SessionFilter.class.getName());

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("#################↓↓SessionFilter↓↓#################");
		
		System.out.println(request.getRequestURI() + " " + request.getMethod());
		System.out.println(request.getParameterMap().toString());
		
		System.out.println("#################↑↑SessionFilter↑↑#################");
		
		
		
		String url = request.getRequestURI();  
		String serviceName = request.getSession().getServletContext().getContextPath();
		
		if (url.indexOf("/Spring_4_Learn_WebProject/token/") == 0) {
			
			// 解决问题, 针对带有Token的请求, 设置为支持跨域
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type");
			
			//response.addHeader("Access-Control-Max-Age", "1800");//30 min
			//response.addHeader("Access-Control-Allow-Origin", "*");
			//headers.add("Access-Control-Allow-Origin", "http://abcd.org "); //allows CORS requests only coming from abcd.org 
			
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia, Authorization,token");
			
			
			filterChain.doFilter(request, response);
		} else {
			filterChain.doFilter(request, response);
		}
		
		
		
	}

}
