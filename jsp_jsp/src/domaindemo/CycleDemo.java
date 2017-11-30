package domaindemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CycleDemo extends HttpServlet{
	
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException{
		
		//request 的生命周期就只有 一次请求
		//session 的生命周期客户端关闭之前
		//servletContext 的生命周期tomcat关闭之前
		
		
		Object num = request.getAttribute("count");
		
		//session
		HttpSession session = request.getSession();
		
		Integer sessionNumber = (Integer)session.getAttribute("count");
		
		//application
		ServletContext context = super.getServletContext();
		
		Integer contextNumber = (Integer)context.getAttribute("count");
		
		if(num == null){
			
			request.setAttribute("count",1);
		}else{
			
			request.setAttribute("count",sessionNumber++);
		}
		
		if(sessionNumber ==  null){
			
			session.setAttribute("count",1);
		}else{
			
			session.setAttribute("count",sessionNumber+1);
		}
		
		if(contextNumber ==  null){
			
			context.setAttribute("count",1);
		}else{
			
			context.setAttribute("count",contextNumber+1);
		}
		
		PrintWriter out= response.getWriter();
		
		out.println(request.getAttribute("count")+"====request");
		out.println(session.getAttribute("count")+"====session");
		out.println(context.getAttribute("count")+"====context");
		
	}

}
