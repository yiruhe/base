package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import query.QueryParameter;
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
					
					
					List<?> PartNameDir = PartNameDao.query();
					
					
					request.setAttribute("partName",PartNameDir);
					
				
					QueryParameter obj =  new QueryParameter();
					
					
					//读取查询的参数
					this.insertinserStudentData(request, obj);
					
					//给jsp用来回现数据
					request.setAttribute("dir",obj);
					
					
					//给jsp
					List<?> list = studentDao.list1(obj);
					
					System.out.println(list);
					
					request.setAttribute("message",list);
					
					System.out.println("跳转中..............");
					
					request.getRequestDispatcher("/WEB-INF/table.jsp").forward(request,response);
				
					System.out.println("跳转完成.............");
				
		}
		
		
		protected void insertinserStudentData(HttpServletRequest request,QueryParameter queryParameter){
			
			//获取参数值
		
			String name = request.getParameter("name");
			String minScore = request.getParameter("minScore");
			String maxScore = request.getParameter("maxScore");
			String departmentId = request.getParameter("dirId");
			String key = request.getParameter("keyword");
	
			
			if(name != null && !"".equals(name)){
				
				queryParameter.setName(name);
			}
			
			if(minScore != null && !"".equals(minScore)){
				
			
				queryParameter.setMinScore(Integer.valueOf(minScore));
			}
			
			if(maxScore != null && !"".equals(maxScore)){
				
				queryParameter.setMaxScore(Integer.valueOf(maxScore));
			}
			
			if(departmentId != null && !"".equals(departmentId) && !"-1".equals(departmentId)){
				
				queryParameter.setDepartmentId(Integer.valueOf(departmentId));
				
			}
			
			if(key != null && !"".equals(key)){
				
				queryParameter.setKeyword(key);
			}
			
			System.out.println(queryParameter);
			
		}
		
			
		
	
}