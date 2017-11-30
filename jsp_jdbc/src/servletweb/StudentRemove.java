package servletweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletdemo.dao.IStudentDAO;
import servletdemo.dao.implement.StudentImplement;

public class StudentRemove extends HttpServlet{
	
		private IStudentDAO student; 
	
		@Override
		public void init(){
			
			student = new StudentImplement();
			
		}
	
		@Override
		public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
			//从数据路删除id数据
			this.student.delete(request.getParameter("id"));
			
			//重新查询并显示
			request.getRequestDispatcher("/list").forward(request,response);
			
			
		}
	

}
