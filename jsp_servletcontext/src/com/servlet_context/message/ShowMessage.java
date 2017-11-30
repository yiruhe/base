package com.servlet_context.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowMessage extends HttpServlet{
	
	private ServletContext context = null;
	
	
	@Override
	public void init(){
		
		//获取上下文对象
		context = this.getServletContext();
		
	}
	
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException
	{
		
		this.doPost(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws IOException
	{
		
		//获取上下文的属性值
		List<String> list = (List)context.getAttribute("message");
		
		System.out.println(list+"=======");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<body>");
		out.println("<meta http-equiv=\"refresh\" content=\"1\" />");
		//打印对象中的数据
		for(int i=1;i<list.size();i++){
			
			out.println(list.get(i));
			
		}
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
	@Override
	public void destroy(){
		
		
		
	}
	

}
