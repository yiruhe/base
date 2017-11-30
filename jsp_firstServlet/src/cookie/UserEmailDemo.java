package cookie;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/user")
public class UserEmailDemo extends HttpServlet{

	@Override
	public void init(){
		
		
	}
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws IOException
	{
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("username");
		
		if(name != null){
			
			name = new String(name.getBytes("ISO-8859-1"),"utf-8");
			
		}
		
		//获取Session
		
		//HttpSession session = request.getSession();
		
		//name = (String)session.getAttribute("username");
		
		
//		接受Cookie
		Cookie[] cookie = request.getCookies();
		
		
		for(Cookie e:cookie){
			
			System.out.println(e.getName());
			System.out.println(e.getVersion());
			if("username".equals(e.getName())){
				
				name = new String(e.getValue().getBytes("ISO-8859-1"),"utf-8");
				
			}
			
		}
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		
		writer.print("welcome "+name+" mister(先生)");

		writer.flush();
		writer.close();
	}
	
}
