package servletweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletdemo.dao.IStudentDAO;
import servletdemo.dao.implement.StudentImplement;

public class DispatcherDemo extends HttpServlet{
	
	private IStudentDAO instantiate;

	public void init(){
		
		
		this.instantiate = new StudentImplement();
		
	}

	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		
		String id = request.getParameter("id");
		
		
		
		/*
		if("".equals(id)){
			
			request.getRequestDispatcher("/input.jsp").forward(request,response);;
			
		}else{		
			request.getRequestDispatcher("/input.jsp").forward(request,response);
		}*/
		
	}
}
