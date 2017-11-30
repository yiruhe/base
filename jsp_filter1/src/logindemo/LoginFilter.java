package logindemo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest  req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//获取当前页面的uri
		String uri = req.getRequestURI();
		
		System.out.println(uri);
		
		//不拦截登陆页,和获取的URI做对比
		if( !"/show/login2.jsp".equals(uri) ){
			
			Object verify = req.getSession().getAttribute("USER_IN_SESSION");
			
			System.out.println("哦,没登录");
			
			//如果Session中的对象不存在,那么跳回登陆页面
			if(verify == null){
				
				res.sendRedirect("/show/login2.jsp");
				
				return;
			}
			
		}
		
		chain.doFilter(request,response);
		
	}

	@Override
	public void destroy() {
		
		
	}

	
	
}
