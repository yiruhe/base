package web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenServlet extends HttpServlet{
	
	
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		//创建一个随机数
		String uuid = UUID.randomUUID().toString();
		
		//把uuid存入session
		request.getSession().setAttribute("TOKEN_IN_SESSION",uuid);
		
		
		request.getRequestDispatcher("/transfer.jsp").forward(request, response);
		
	}

}
