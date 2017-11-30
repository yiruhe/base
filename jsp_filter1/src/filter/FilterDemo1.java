package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements javax.servlet.Filter{

	/**
	 * 在容器启动的时候,filter就初始化了
	 * 
	 * 
	 */
	public FilterDemo1(){
		
		System.out.println("Filter instantiation");
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		System.out.println("Filter init method");
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	
		
		System.out.println("Filter.....Two");
		
		System.out.println("Filter===two===before");
		
		//传递给下一个站点,没有这个是不会去请求资源的
		chain.doFilter(request,response);
		System.out.println("Filter===two===after");
		
	}
	
	@Override
	public void destroy() {
		
		
		System.out.println("Filter destroy");
		
	}

	

	
	
	
	
	
	
}