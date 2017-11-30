package com.servlet.http;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServlet extends GenericServletDemo{

	
	public void init(){
		
			
	}

	
	@Override
	public void service(ServletRequest request,ServletResponse response){
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res =(HttpServletResponse)response;
		
		
		service(req,res);
	}
	
	//因为要处理Http类型的请求,响应，为此需要重新设计
	public void service(HttpServletRequest req,HttpServletResponse res){
		
		System.out.println(req.getMethod());
		
		if("GET".equals(req.getMethod())){
			
			this.doGet(req,res);
			
		}else if("Post".equals(req.getMethod())){
			
			this.doPost(req,res);
		}
		
		
	}
	
	//带do的方法叫钩子方法(hook)
	public void doGet(HttpServletRequest req,HttpServletResponse res){
		
		
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res){
		
		
		
	}
	
	
}
