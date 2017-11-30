package expression.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ELServletDemo extends HttpServlet{

	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		User user = new User();
		
		request.setAttribute("user",user);
		//转发
		request.getRequestDispatcher("/JSTL.jsp").forward(request, response);
		
	}

	
}

