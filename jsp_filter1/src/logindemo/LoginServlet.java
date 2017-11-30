package logindemo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/menu")
public class LoginServlet extends HttpServlet{
	
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response){
		
		String name = request.getParameter("username");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("USER_IN_SESSION",name);
		
		
		try {
			
			response.sendRedirect("Menu.jsp");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}