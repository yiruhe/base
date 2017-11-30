package com.servlet_context.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServletDemo extends HttpServlet{

	private ServletContext application = null;
	
	@Override
	public void init(){
		
		//通过上下文存放数据
		//获取上下文对象:
		application = this.getServletContext();
		
		//将消息存放在内存区域:
		List<String> message = new ArrayList<>();
		
		System.out.println("initialized.......");
		
		//设置上下文属性
		application.setAttribute("message",message);
		
	}
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		//把数据发给post的业务
		this.doPost(request,response);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException{
		
		String commit = request.getParameter("commit");
		String selection = request.getParameter("selection");
		
		String address = request.getRemoteAddr();
		System.out.println(address+"========");
		StringBuilder buffered = new StringBuilder(30);
	
		buffered.append(address);
		buffered.append(commit);
		buffered.append("<img src=faces/"+selection+".gif />");
		
		
		//从上下文获取List对象
		List<String> list = (List)application.getAttribute("message");
			
		System.out.println("execute add");
		
		list.add(buffered.toString());
	
	}
	
	@Override
	public void destroy(){
		
		
	}
	
}
