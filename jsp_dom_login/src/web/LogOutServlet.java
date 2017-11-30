package web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutServlet extends HttpServlet{

	
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
		//两种方式: 1: 一种就是删除属性:USER_IN_SESSION  2:一种就是销毁: 销毁session对象(使用这种)
		
		
		//销毁当前client的session对象
		request.getSession().invalidate();
		
		//并且跳回登录对象
		response.sendRedirect("/show/Login.jsp");
	}
	
}
