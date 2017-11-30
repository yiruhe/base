package cookie;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		value={"/examine/cookie"},
		initParams={
			@WebInitParam(name="encoding",value="utf-8")
		}	
//		,
//		loadOnStartup=0
		
)
public class LoginDemo extends HttpServlet{
	
	/**
	 * 第一次客户端请求的时候
	 * 1.创建Servlet对象
	 * 2.调用init方法
	 * 3.调用service方法
	 */
	
	@Override
	public void init(ServletConfig config){
		
		String encoding = config.getInitParameter("encoding");
		
		System.out.println(encoding+"====");
		
	}
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws IOException
	{
		
		
		
		//设置响应头,打开输出流之前设置输出格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		//设置Cookie
		Cookie  cookie = new Cookie("username","environment");
//		cookie.setPath("/");
		response.addCookie(cookie);

		//使用session传递数据
//		HttpSession session = request.getSession();
//		
//		String id = session.getId();
//		
//		session.setAttribute("username","organize");
//		
//		//session.setMaxInactiveInterval(10);
//		
		PrintWriter out = response.getWriter();
//		
//		String url = response.encodeURL("/test/user");
		
		System.out.println();
		
		out.print("<a href=http://localhost:8080/test/authorized/user>邮件</a>");
		//out.print("<a href="+url+">邮件</a>");
		
		out.flush();
		out.close();
	}
	
	@Override
	public void destroy(){
		
		
	}

}
