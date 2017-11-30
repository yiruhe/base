package com.notes.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notes.StringUtils.StringUtils;
import com.notes.connection.ConnectionUtils;

public class ServletLoginDemo extends HttpServlet{

	@Override
	public void init(){
		
	}
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		
		
		this.doPost(request,response);
	}
	
	
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(name);
		
		try{
			System.out.println(StringUtils.isEmpty(name));
			
			if(StringUtils.isEmpty(name) && StringUtils.isEmpty(password)){
				
				request.getRequestDispatcher("error.html").forward(request,response);
				
			}else{
				
				if(ConnectionUtils.isContainUser(name, password)){
					
					response.sendRedirect("success.html");
					
				}else{
					
					request.getRequestDispatcher("error.html").forward(request,response);
					
				}
				
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		
	}
	
	@Override
	public void destroy(){
		
	} 
}
