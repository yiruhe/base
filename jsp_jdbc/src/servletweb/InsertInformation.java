package servletweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletdemo.dao.IStudentDAO;
import servletdemo.dao.implement.StudentImplement;

public class InsertInformation extends HttpServlet{

	private IStudentDAO instantiate;
	
	@Override
	public void init(){
		
		instantiate = new StudentImplement();
	}
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException
	{
		
		
		String name = request.getParameter("username");
		String department = request.getParameter("department");
		String score = request.getParameter("score");
		
		String id = request.getParameter("id");
		System.out.println(id+"=====");
		if(!"".equals(id)&& id!= null){
			
			System.out.println("updating");
			instantiate.update(id,name,department,score);
			
		}else{
					
			System.out.println("saving");
			instantiate.save(name,department,score);
		
		}
		System.out.println("updated succesfully");
		request.getRequestDispatcher("/list").forward(request,response);;
		System.out.println("despatcher succesfully");
	}
	
}
