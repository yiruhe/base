package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page.PageList;
import query.StudentQuery;
import dao.IEngineerDirDao;
import dao.IStudentDao;
import dao.implement.EngineerDaoImplement;
import dao.implement.StudentDaoImplement;


public class StudentServelt extends HttpServlet{
	
	private IStudentDao studentDao = new StudentDaoImplement();
	private IEngineerDirDao engineerDao = new EngineerDaoImplement();
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException, ServletException
	{
		//这时候存在一个问题,在点击下一页的时候,参数丢失
		
		request.setCharacterEncoding("UTF-8");
		
		StudentQuery querySet = new StudentQuery();
		

		this.insert(request,querySet);

		request.setAttribute("userData",querySet);
		
		PageList dataList = studentDao.advancedQuery(querySet);
		
		
		
		request.setAttribute("pageSet",dataList);
		
		//查询所有的系
		List engineerDir = engineerDao.query();
		
		request.setAttribute("engineerDir", engineerDir);
		
		//跳转
		request.getRequestDispatcher("WEB-INF/view/pageTest.jsp").forward(request,response);
		
		
	}
	
	
	//把数据添加到对象
		public void insert(HttpServletRequest request,StudentQuery set){
			
			String name = request.getParameter("name");
			String minScore = request.getParameter("minScore");
			String maxScore = request.getParameter("maxScore");
			String engineerId = request.getParameter("engineerId");
			String currentPage = request.getParameter("currentPage");
			String pageItem = request.getParameter("pageItem");
			
			
			if(pageItem != null && !"".equals(pageItem)){
			
				set.setPageSize(Integer.valueOf(pageItem));
				
			}
			
			
			if(currentPage != null && !"".equals(currentPage)){
				
				set.setCurrentPage(Integer.valueOf(currentPage));
			}
			
			if(name != null && !"".equals(name)){
				
				set.setName(name);
				
			}
			
			if(engineerId != null && !"".equals(engineerId) && !engineerId.equals("-1")){
				
				set.setEngineerId(Integer.valueOf(engineerId));
				
			}
			
			
			if(minScore != null && !"".equals(minScore)){
				
				set.setMinScore(Integer.valueOf(minScore));
				
			}
			
			if(maxScore != null && !"".equals(maxScore)){
				
				set.setMaxScore(Integer.valueOf(maxScore));
				
			}
			
		}
	
}