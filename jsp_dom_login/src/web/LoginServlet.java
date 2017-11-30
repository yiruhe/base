package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IUserDao;
import dao.implement.UserImplement;
import domain.User;

public class LoginServlet extends HttpServlet{

	private IUserDao  dao = new UserImplement();
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		
		//获取请求参数
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		//根据用户名查询数据库
		User user =  dao.getUserByUserName(userName);
		
		
		if(user == null){
			
			request.setAttribute("tips","账号,或密码不正确！");
			
			System.out.println("账户错误。。。。。");
			request.getRequestDispatcher("/Login.jsp").forward(request,response);
			
			return;
		}
		
		if(!user.getPassword().equals(password)){
			

			request.setAttribute("tips","账号或密码不正确！");
			
			System.out.println("密码错误。。。。。");
			request.getRequestDispatcher("/Login.jsp").forward(request,response);
			
			return;
			
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("USER_IN_SESSION",user);
		
		response.sendRedirect("list");
		
	}
	
}
