package com.spring4.learn.webproject.transaction.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("#################↓↓↓↓#################");
		
		System.out.println(request.getRequestURI() + " " + request.getMethod());
		System.out.println(request.getParameterMap().toString());
		
		System.out.println("#################↑↑↑↑#################");
		
		filterChain.doFilter(request, response);
	}

}
