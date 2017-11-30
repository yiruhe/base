package com.servlet.http;

import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract  class  GenericServletDemo implements Servlet,ServletConfig{
	
	//每一个自定义的Servlet类都会定义获取configuration对象,所以应该重构,
	//又因为是统一体系,我们就用继承解决这一问题  
	//所以就定义了这个GenericServlet的类
	
	
	//init方法:
		//执行步骤：
			//1.调用servlet的构造器,创建Servlet的对象
			//2.调用带有参数的init方法完成初始化操作
			//此时servlet中没有带有config参数的init方法
			//就去servlet的父类方法去寻找并调用带参数的config方法
	
	
	
	
	private ServletConfig configuration = null;
	
	@Override //初始化
	public void init(ServletConfig config){		
		//初始化参数:
			//<init-param>
			// <param-name>
			//<param-value>
		this.configuration = config;
		
		this.init();
		//表面上看是调用GennericServlet中无参数的init方法
		//但是此时:servlet覆盖了init方法,由于多态
		//调用了子类的init方法
	}
	
	public void init(){
		
	}
	
	
	@Override //获取servlet configuration
	public ServletConfig getServletConfig(){		
		
		return this.configuration;
	} 
	
	@Override //服务
	abstract public void service(ServletRequest request,ServletResponse response);
	@Override
	public void destroy(){}
	
	
	@Override
	public String getServletInfo(){
		
		
		return null;
	}
	
	@Override
	public String getServletName(){
		
		
		return configuration.getServletName();
	}
	
	@Override
	public ServletContext getServletContext(){
		
		
		
		return configuration.getServletContext();
	}
	
	@Override
	public String getInitParameter(String name){
		
		return configuration.getInitParameter(name);
	}
	
	@Override
	public Enumeration<String> getInitParameterNames(){
		
		return configuration.getInitParameterNames();
	}
	
}
