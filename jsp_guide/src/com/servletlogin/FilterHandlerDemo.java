package com.servletlogin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterHandlerDemo implements Filter{
	
	private FilterConfig configuration = null;
	
	@Override
	public void init(FilterConfig configuration){
		
		//初始化时把实例赋给私有变量
		this.configuration = configuration;
		
	}

	@Override
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain){
		
		try{
			//利用configuration实例获取数据
			String value = configuration.getInitParameter("encoding");
			
			if(configuration != null && value.equals("")){
				
				request.setCharacterEncoding(value);
				response.setCharacterEncoding(value);
				response.setContentType("text/html;charset="+value);
				
			}
			
			System.out.println("filter handler");
			//传给下一个过滤器
			chain.doFilter(request, response);
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}

	@Override
	public void destroy(){
		
		
		
	}


}
