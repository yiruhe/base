package com.servlet_context.basic;

public class Basic {
	
	//只有WebRoot下的文件才会部署到tomcat
	
	//当访问时,就会去web.xml,去找请求地址(就是url-pattern),再找到对应的类,
	
	//获取上下文的对象是服务器中开辟的一块内存区域(quite 全局对象)
	//servletContext  //一直存在随着容器
	//this.getServletContext();
	//可以通过上下文存放数据
//			xml：参数配置
//			context-param
//				param-name
//				param-value
//	
	//servlet默认情况下是在服务器启动之后,第一次从web上访问后才会执行init方法初始化,在web.xml配置servlet的时候,
	//我们可以通过加<load-on-startup>0<load-on-startup>这样的标签,让tomcat启动时就加载对应的servlet,并
	//执行init方法
	
	//load-on-startup  0   //数字越小越靠前
	
	//可以处理空指针异常
	
	//HttpServletRequest   //获取用户请求的参数
	
	//根据名称获取请求头中的某个信息
	//request.getHeader("xxx");
	
	
	//servletConfig  //可以获取web.xml里面配置的键值对
	//参数配置在servlet标签  //只有配置了这个标签的对象,对象才能访问
	
	
	
	//(redirect): 让浏览器重新请求页面
	//Dispatcher()：服务器自己跳转页面
	
	
	//作用域:
	//就是为了解决数据的存储可数据的传递,而在servlet里面以键值对存在的方法
	//上下文作用域:servletContext
	//容器启动完毕就一直存在,所有的servlet都可以获取到,你在任何一个地方存储了任何
	//的servlet都可以获取到
	
	
//	session是由请求决定的  //作用域在session(浏览器内都可以访问)
	//configuration:
	//session-config
			//会话的实效30分钟,30钟没有任何请求,就清空
		//<session-timeout>30分钟
	
	//cookie：注意点cookie不能写入中文,
	//可以利用URLEncoder
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
