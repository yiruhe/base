package forward;

public class DomainDemo {
	
	//servlet的三大作用域:
//	request:每次请求都是一个新的request对象,如果在WEB组件需要共享同一个请求数据,只能使用请求转发
//	session:每一次会话都是一个新的session对象,如果需要在一次会话中多次请求需要共享数据,只能session
//	application:应用对象,Tomcat启动到Tomcat关闭,在一个应用中有且只有一个application对象,作用域在
	//整个Web应用,可以实现多次会话
	
	//在哪个作用域设置值,就在哪个作用域取值。
	
	
	//Servlet接口:应用只有一个
		//1.在Servlet类中,super.getServletContext();//GenericSrevlet实现了ServletConfig,所以可以直接调用父类实现的方法
		//2.通过请求对象来获取:request.getServletContext(); //tomcat7才有的
		//3.通过session获取  request.getSession().getServletContext();
	
	
//	全局参数
//		全局初始化参数
			//<context-param>
				//<servlet-name>
				//<servlet-value>
	//note:
		//servlet接口中的获取初始化参数方法,只能获取当前Srevlet自身的初始化参数,不能获取全局
		//servletContext接口中的获取初始化参数的方法,只能获取全局的初始化参数,不能获取全局的初始化参数
	

}
