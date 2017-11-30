package servletweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletdemo.dao.implement.StudentImplement;
import servletdemo.domain.Student;


public class StudentTable extends HttpServlet{

	

	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		
		List<Student> list = new StudentImplement().query();
		
		request.setAttribute("student", list);
		
		System.out.println("hello");
		
		//转发
		request.getRequestDispatcher("/studentList.jsp").forward(request,response);;
		
		
	}

}
