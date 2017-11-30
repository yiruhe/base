package comment;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class CommentFilter implements Filter{

	
	@Override
	public void init(FilterConfig config){
		
		
	}
	
	@Override
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException{
		
		//由于parameter的参数只能获取,不能修改所以我们只能通过定义子类来实现
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		//处理(构造函数主要把request对象传递给顶级实现类)
		//多态的体现,继承了HttpServletRequest对象
		HttpServletRequest disposeReq = new MessageWrapper(req);
		
		//传递处理了的request对象
		chain.doFilter(disposeReq, response);
		
	}
	
	@Override
	public void destroy(){
		
		
		
	}
}
