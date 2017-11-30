package demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDemoFilter implements Filter{

	private FilterConfig configuration = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.configuration = filterConfig;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse res = (HttpServletResponse)response;
		
			String encoding = configuration.getInitParameter("encoding");
			boolean verify = Boolean.valueOf(configuration.getInitParameter("verify"));
			
			
			//修改字符集
			//1.把UTF-8设置到web.xml文件中,更好
			//2.request.getCharacterEncoding() 以防别人已经设置了编码集
			//3.是否强制使用自己设置的编码集
			
			if(		encoding != null && !"".equals(encoding) && 
					(request.getCharacterEncoding() == null || verify )
					
					){
				
				req.setCharacterEncoding(encoding);
			}
		
			
			chain.doFilter(req,res);
			
	}

	@Override
	public void destroy() {
		
		
	}
	
	
	
	
}