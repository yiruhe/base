package jsp;

public class ImplicitObject {
	
	//jsp中有9个不用声明和定义,直接使用的对象
	//内置对象    		内置对象的类型
					
	//request   	HttpServletRequest   请求对象
	//response		HttpServletResponse	   响应对象
	//pageContext	PageContext			当前jsp作用域对象
	//session		HttpSession			会话对象(page指令的session=true"默认",为true才可以访问)
	//exception		Throwable			异常对象(封装了当前JSP的异常信息)
	//application	ServletContext		当前Web应用对象
	//config		ServletConfig		当前servlet的信息配置对象
	//out			JspWriter			字符输出流对象
	//page			Object				当前Servlet对象
	
	
/*	<servlet>    
 * 
	    <!--指定servlet的名字-->  
	    <servlet-name>config</servlet-name>  
	    
	      
	    <!--指定哪一个JSP页面配置成Servlet-->  
	    <jsp-file>/configTest2.jsp</jsp-file>  //配置
	    
	    
	    
	    
	    <!--配置名为name的参数，值为yeeku-->  
	    <init-param>    
	        <param-name>name</param-name>    
	        <param-value>yeeku</param-value>    
	    </init-param>    
	    <!--配置名为age的参数，值为30-->  
	    <init-param>    
	        <param-name>age</param-name>    
	        <param-value>30</param-value>    
		</init-param>    
	</servlet>    
	<servlet-mapping>   
    	<!--指定将config Servlet配置到/config路径-->   
    	<servlet-name>config</servlet-name>    
    	<url-pattern>/config</url-pattern>    
	</servlet-mapping>
	*/
	
	
	//四大作用域
		//作用域对象就只能造自己的作用域范围之内共享数据
//	作用域对象名称  作用域对象的类型
//	pageContext(alias:page)  PageContext   当前jsp作用域对象//一般都是jsp标签用来存值的
//	request		HttpServletRequest
//	Session    HttpSession   当前会话
//	application
	
	
	//动作元素:
	//<jsp:forward/> 请求转发标签
	//请求转发可以携带参数
		//<jsp:param name='' value='' />
	
	//静态和动态包含:
		//静态:
//			使用jsp的include指令
			//<%inculde file="被包含的页面文件"%>
		//特点:
			//在翻译阶段就已经把多个jsp,合并在一起。
	//动态
		//使用jsp动作指令:
//			<jsp:include>
//				<jsp:param name="" value="">
//			</jsp:include>
	
		//特点:
			//把每一个jsp都翻译成Servlet类,在运行时期,动态的合并在一起
	
	
}
