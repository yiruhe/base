package login.logindemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDemo extends HttpServlet{
//	假设tomcat中web应用程序（webapp）有一个名为my的web应用程序，且servlet的名字为HelloWorldServlet
//
//	1.form aciton中的反斜杠： 代表域名 的访问路径(即webapp的根路径 ),如:代表192.168.0.1 。 它不包括web应用程序的名称(这里即my)。
//
//	故在form的action要写上/ my/ HelloWorldServlet
//	
//	2.web.xml中<servlet-mapping>的反斜杠：代表域名+web应用程序名 , 如:192.168.0.1/my 。
//
//	故在 <servlet-mapping>中只需写上 / HelloWorldServlet,而没有/my
	
	@Override
	public void init(){
		
		
	}
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{

		try{
			
			request.setCharacterEncoding("UTF-8");
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		String user = request.getParameter("username");
		String password = request.getParameter("password");

		//String username = new String(user.getBytes("ISO-8859-1"),"utf-8");
		
		System.out.println(user);
		
		//获取输出流前设置响应头:
		PrintWriter out = response.getWriter();
		
		out.println(user);
		out.println(user);
		//设置mime类型
		response.setContentType("text/html;charset=utf-8");
		out.flush();
		
		out.close();
		
	}
	

}
