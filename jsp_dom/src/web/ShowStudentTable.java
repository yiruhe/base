package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IPartNameDao;
import dao.IStudentDao;
import dao.implement.DepartNameImplement;
import dao.implement.StudentDaoImplement;
import domain.DepartmentName;
import domain.Student;

public class ShowStudentTable extends HttpServlet{
	
		private IStudentDao studentDao = null;
		private IPartNameDao PartNameDao = null;
	
		@Override
		public void init(){
			
			studentDao = new StudentDaoImplement();
			PartNameDao = new DepartNameImplement();
		}
	
	
		@Override
		public void service(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException
		{
			
				
				request.setCharacterEncoding("UTF-8");	
				//
				String instruction = request.getParameter("cmd");
				
				if("remove".equals(instruction)){
				
					this.delete(request,response);
					
				}else if("edit".equals(instruction)){
				
					System.out.println("==============");
					this.edit(request,response);
				
					
				}else if("add".equals(instruction)){
					
					this.add(request,response);
					
				}else{
					
					List<Student> list = this.studentDao.query();			
					request.setAttribute("message",list);
					
					System.out.println("跳转中..............");
					
					request.getRequestDispatcher("/WEB-INF/table.jsp").forward(request,response);
				
					System.out.println("跳转完成.............");
					
				}
				
		}
		
		public void delete(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException
		{
				
			//获取id
			String id = request.getParameter("id");
			//判断
			if(id != null && !"".equals(id)){
				System.out.println("删除开始......");
				
				 System.out.println(studentDao.delete(Integer.valueOf(id)));		
				
				 System.out.println("删除完成......");		
			}
			
			//返回页面
			response.sendRedirect("list");
		}
		
		
		public void edit(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException
		{
			
			String id = request.getParameter("id");
			List<DepartmentName> departName = PartNameDao.query();
			

			request.setAttribute("departName",departName);			
			
			if(id != null && !"".equals(id)){
				
				Student student = studentDao.get(Integer.valueOf(id));
				
				request.setAttribute("message",student);	
			}
			
			//跳转编辑页面
			request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request,response);
		}
		
		
		//添加数据
		public void add(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException
		{
			Student student = new Student();
			//获取各参数的值
			
			this.insertinserStudentData(request,student);
		
			System.out.println(student);
			
			if(student.getId() != null){
				
				studentDao.update(student);
				
			}else{
				//添加到数据库
				studentDao.save(student);
			}
			
			
			System.out.println("保存成功");
			
			//返回页面
			response.sendRedirect("list");
			
		}
		
		
		
		protected void insertinserStudentData(HttpServletRequest request,Student student){
			
			//获取参数值
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String department = request.getParameter("department");
			String score = request.getParameter("score");
			String deparmentIndex = request.getParameter("departmentName");
			
			System.out.println(deparmentIndex);
			
			//注入参数值
			if(id != null && !"".equals(id)){
				student.setId(Long.valueOf(id));
			}
			student.setDepartment(department);
			student.setName(name);
			student.setScore(Integer.valueOf(score));
			//student.setDeparmentIndex(Integer.valueOf(deparmentIndex));
			
			
			if(deparmentIndex != null && !"".equals(deparmentIndex)){
				
				DepartmentName dir = new DepartmentName();
				
				dir.setDepartIndex(Integer.valueOf(deparmentIndex));
				
				//添加进学生对象
				student.setDepartmentDirectory(dir);
			}
			
		}
		
			
		
	
}