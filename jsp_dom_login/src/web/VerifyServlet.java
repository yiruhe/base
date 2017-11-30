package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyServlet extends HttpServlet{

	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String verify = request.getParameter("verify");
		
		String str = (String)request.getSession().getAttribute("VERIFY_IN_SESSION");
		
		if(!str.equalsIgnoreCase(verify)){
			
			request.setAttribute("tips","验证码错误！....");
			
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			
			
			return;
			
		}
		
		//删除,以免重复提交
		request.getSession().removeAttribute("VERIFY_IN_SESSION");
		
		System.out.println("验证成功！.........");
		
	}
	
	
}
