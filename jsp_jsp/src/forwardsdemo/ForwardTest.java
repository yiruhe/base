package forwardsdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dispatch")
public class ForwardTest extends HttpServlet{

//	before..........
//	hello.......
//	after....   转发的页面执行完毕后,还是会回到原本的类,但是负责转发的类,是无法响应的,响应由转发到的servlet进行
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException
	{
		
		System.out.println(request+"====");
		
		System.out.println("hello.......");
		
		PrintWriter out = response.getWriter();
		
		out.println("virtual environment");
		
	}
	
}
