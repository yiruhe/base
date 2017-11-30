package web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransferServlet extends HttpServlet{

	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response){
		
		String token = request.getParameter("token");
		
		
		if(request.getSession().getAttribute("TOKEN_IN_SESSION").equals(token)){
			
			//登录成功后删除该验证,防止重复提交
			request.getSession().removeAttribute("TOKEN_IN_SESSION");
			
			System.out.println("succeed");
			
		}else{
			
			
			System.out.println("失败");
			
		}
		
	}
	
	
}
