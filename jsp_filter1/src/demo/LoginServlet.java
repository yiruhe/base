package demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response){
		
		
		String message = request.getParameter("message");
		
		System.out.println(message);	
		
	}
	
	
}
