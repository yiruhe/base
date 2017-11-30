package basic;

public class Basic{
	
	//DRY:
		//1.开发中拒绝代码重复
		//2.责任分离原则:做个自最擅长的事
	
	//servlet: 只做三件事:  请求  处理  响应   更变字符集不应由servlet去做
	
	
	//自定义一个类(xxxFilter),实现javax.servlet.Filter接口
	//实现Fileter接口中的方法(init) doFilter(执行过滤操作)
	//告诉Tomcat来帮助我们管理Filter(1:web.xml做配置) 2:webFilter("/资源名")
	
	//Filter可以修改一个request,response
	
	//注意:过滤器的url-pattern的文本内容是Filter对那些资源做过滤操作
		//比如: /hello.jsp  ：说明当前Filter只会对/hello.jsp做拦截/过滤
		//   /system/* 	   ：  说明当前Filter只会对一/system/作为前缀的资源路径做拦截

	//使用注解配置:Filter的执行顺序由Filter类名的字母顺序来决定
	
	//初始化：
	//在Tomcat启动的时候,就创建好Filter对象,并调用init方法.
	
	
	
	//在Servlet被调用之前截获
	//被过滤器拦截后,就不会去请求资源,也不会出现404
	
	//双向过滤器
	
	//
	
	/*
	  	chain.doFilter()之前的代码——>……——>第n个过滤器的chain.doFilter()之前的代码
	  	——>所请求 servlet的service()方法中的代码——>所请求servlet的doGet()或doPost()方法中的代码
		——>第n个过滤器的chain.doFilter()之后的代码——>……——>第二个过滤器的chain.doFilter()之后的代码
		——> 第一个过滤器的chain.doFilter()之后的代码。
	
	*/
	
//	程序中,存在多个过滤器的时候,过滤器的执行顺序:
		//在xml中,由mapping的排列顺序来决定时
		//执行的方式类似于递归
	
	/*
	 
	 filter中<servlet-name> 可对相对应的servlet做拦截 
	  
	  <dispatcher>子元素可以设置的值及其意义
			REQUEST：当用户直接访问页面时，Web容器将会调用过滤器。如果目标资源是通过RequestDispatcher的include()或forward()方法访问时，那么该过滤器就不会被调用。
			INCLUDE：如果目标资源是通过RequestDispatcher的include()方法访问时，那么该过滤器将被调用。除此之外，该过滤器不会被调用。
			FORWARD：如果目标资源是通过RequestDispatcher的forward()方法访问时，那么该过滤器将被调用，除此之外，该过滤器不会被调用。
			ERROR：如果目标资源是通过声明式异常处理机制调用时，那么该过滤器将被调用。除此之外，过滤器不会被调用。
			
		拦截在这种定义的值,会再次进入拦截器,
				顺序:
					先退出再次进入的拦截,然后在退出首次进入的拦截器
			*
			*/
}