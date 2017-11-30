package comment;

import java.io.UnsupportedEncodingException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/comment")
public class CommentServlet extends HttpServlet{
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println(request);
		
		String comment = request.getParameter("comment");
		
		//在这里处理是不合理的,所以要把这个添加到Filter中
		//comment = FilterKeyWord.dispose(comment);
		
		System.out.println(comment);
		
		
		
	}
	
} 