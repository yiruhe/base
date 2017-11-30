package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IEngineerDirDao;
import dao.IStudentDao;
import dao.implement.EngineerDaoImplement;
import dao.implement.StudentDaoImplement;
import domain.Engineer;
import domain.Student;

public class StudentServelt extends HttpServlet{
	
	private IStudentDao studentDao = new StudentDaoImplement();
	private IEngineerDirDao engineerDao = new EngineerDaoImplement();
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException, ServletException
	{
		
			request.setCharacterEncoding("utf-8");
			String cmd = request.getParameter("cmd");
		
			System.out.println(cmd);
		
			switch(cmd == null ? "":cmd){
				
				case "edit":
					
					this.editTable(request,response);break;
			
				case "delete":
					
					this.deleteData(request,response);break;
				case "update":
					
					this.update(request,response);break;
					
				default:
					
					this.list(request,response);
			}
		
		
	}
	
	
	//显示数据的数据
	public void list(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException
	{
			List<?> list = studentDao.query();
		
			request.setAttribute("message",list);
		
			request.getRequestDispatcher("WEB-INF/view/table.jsp").forward(request,response);
		
		
	}


	//添加或者更新一个数据
	public void editTable(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		System.out.print(id);
		
		if(id != null && !"".equals(id)){
			
			Student student = studentDao.get(Integer.valueOf(id));
		
			request.setAttribute("message",student);
			
		}
		
		List<Engineer> list = engineerDao.query();
		
		request.setAttribute("engineerList",list);
	
		request.getRequestDispatcher("WEB-INF/view/edit.jsp").forward(request,response);;
	}
	
	//删除一个数据
	public void deleteData(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String id = request.getParameter("id");
		
		if(id != null && !"".equals(id)){
			
			studentDao.delete(Integer.valueOf(id));
		}
		
		
		response.sendRedirect("list");
		
	}
	
	//删除或添加一个数据
	public void update(HttpServletRequest request,HttpServletResponse response)
			throws IOException
	{
		
		Student student = new Student();
		
		this.inser(request,student);
		
		System.out.println(student);
		
		if(student.getId() != null){
			
			
			studentDao.update(student);
		}else{
			
			
			studentDao.save(student);
		}
		
		response.sendRedirect("list");
		
	}
	
	//把数据添加到对象
	public void inser(HttpServletRequest request,Student student){
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String score = request.getParameter("score");
		String department = request.getParameter("department");
		String engineerId = request.getParameter("engineerId");
		
		if(id != null && !"".equals(id)){
			
			student.setId(Integer.valueOf(id));
			
		}
		if(name != null && !"".equals(name)){
			
			student.setName(name);
			
		}
		if(score != null && !"".equals(score)){
			
			student.setScore(Integer.valueOf(score));
			
		}
		
		if(department != null && !"".equals(department)){
			
			student.setDepartment(department);
			
		}
		
		if(engineerId != null && !"".equals(engineerId)){
			
			student.setEngineerId(Integer.valueOf(engineerId));
			
		}

		
	}
	
}