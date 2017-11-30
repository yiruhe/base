package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterDemo implements javax.servlet.Filter{

	/**
	 * 在容器启动的时候,filter就初始化了
	 * 
	 * 
	 * 
	 * 执行循序
	 * 	Filter===one===before
		Filter.....Two
		Filter===two===before
		Filter.....Three
		Filter===three===before
		hello........................
		Filter===three===after
		Filter===two===after
		Filter===one===after
	 * 
	 */
	public FilterDemo(){
		
		System.out.println("Filter instantiation");
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		System.out.println("Filter init method");
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	
		System.out.println(request);
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		
		System.out.println("Filter.....One");
		
		System.out.println("Filter===one===before");
		
		System.out.println("过滤的资源"+req.getRequestURL());
		//传递给下一个站点,没有这个是不会去请求资源的
		chain.doFilter(request,response);
		
		System.out.println("Filter===one===after");
		
	}
	
	@Override
	public void destroy() {
		
		
		System.out.println("Filter destroy");
		
	}

	

	
	
	
	
	
	
}