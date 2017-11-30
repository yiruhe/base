package forwardsdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardDemo extends HttpServlet{
	
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException
	{
		
		//转发:
		System.out.println("before..........");
		
		System.out.println(request+"=====");
		
		PrintWriter out = response.getWriter();
		
		out.println("before");
		
		//转方:  1次请求
		// /forward/httPs:/www.baidu.com  请求转发是无法访问百度的,只能在项目跳砖
//		request.getRequestDispatcher("/dispatch").forward(request,response);
		
		//重定向: 2次请求
		//可以访问外网,因为浏览器再次发送了请求
		response.sendRedirect("baidu.com");
		
		out.println("after");
		System.out.println("after....");
	}

}
