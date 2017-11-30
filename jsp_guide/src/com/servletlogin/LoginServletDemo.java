package com.servletlogin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServletDemo extends HttpServlet{


	//init
	@Override
	public void init(){
		
		System.out.println("initialized");
	}
	
	//request
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		
		//让get/set使用相同的业务逻辑
		this.doPost(request,response);
		
		System.out.println("I am get protocol");
	}
	
	//response
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		
	
		try{
			System.out.println("I am post protocol");
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			
			PrintWriter writer = response.getWriter();
			
			writer.println("<h1>username= "+name+"</h1>");
			writer.println("<h1>password = "+password+"</h1>");
			
			writer.flush();
			writer.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		
	}
	
	//destroy
	@Override
	public void destroy(){
		
		
		
	}
	
	
	
}
