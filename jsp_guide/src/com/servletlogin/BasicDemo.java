package com.servletlogin;

public class BasicDemo {
	//Servlet容器为JavaWeb应用提供运行时环境,它是负责管理servlet和jsp的生命周期,以及管理他们的
	//共享数据
	//servlet容器也称JavaWeb容器,或者Servlet/JSp容器
	//servlet是javaee的组件,也是javaEE的一个规范
	//服务器是对Servlet的一个实现
	
	
	//jstl.jar 接口
	//standar.jar 实现
	//jsp-api  自定义标签库
	//el-api
	
	//如果出现错误  就在setup.bat文件后加上pause
	//tomcat目录:
//		bin程序文件目录,可执行文件
//		conf:服务器配置文件目录
//		lib:依赖jar
//		logs:服务器运行时的日志记录文件
//		temp：临时文件存放目录
//		webapps：项目部署目录
	
	
	//tomcat插件的安装:
		//eclipse4.6 不在支持原来的tomcat插件,
		//安装tomcat插件有两种方式,
		//1:放入eclipse目录的dropins目录
		//2:新建一个文件,内容为 path=xxx/eclipse/dropins/xxx.jar;
				//其中:eclipse/dropins/插件  --->是必须的  还有路径不能含有中文
	
	
	
	
//	web-inf  该路径目录下的文件外界访问无效,有WEB服务负责调用  //必须大写
	//classes目录:
	//lib目录
	//web.xml
	
	
	//WebRoot：用来存放所有的资源文件,只有WebRoot下的文件才会部署到Tomcat
	//contextRoot：你要访问的上下文根目录
	
	//tomcat启动的时候src原文件下面所有的类都会编译到WebRoot/Web-Inf/classes下面
	
	//wecome-file  访问一个项目默认进入的页面 ，标签里的页面会从上直下加载文件
	
	
//	1.继承HttpServlet
//	2.重写init doGet doPost destroy
//	3.在web.xml中配置这个servlet
//	4.通过注解的方式配置servlet
	
//	配置servlet xml
//		<servlet>
	//		servlet-name servlet的名字,在整个项目中要保证唯一性unique
	//		servlet-class 完整的限定名（包名+类名）
//		</servlet>
	
//	<servlet-mapping>
		//要映射的servlet名字
//		servlet-name
	//servlet的访问路径
//		url-pattern
	
//	还可以通过注解的方式@WebServlet(name="",urlPatterns={....})
	
	
	//service 是做doGet doPost分发的,自己可以覆盖父类的service方法  
	
	
//	编码问题:
//		项目编码
//		html页面,jsp页面设置为utf-8
//		request.setCharacterEncoding();
//		response.setCharacterEncoding();
//		response.setContentType("text/html;charset=utf-8");
		
//	    doget
//			利用String中的方法,把接受的字符转化为字节,然后指定编码
//			修改tomcat中的配置文件URIEncoding="utf-8"
	
	
	//请求过滤器:filter
//		继承filter接口
		/*filter
			filter-name
			filter-class
				(配置初始化参数)configuration initialized parameter
			init-param
				param-name
				param-value
			init
		  filter
		  
		  filter-mapping
		  	filter-name
		  	//pattern是/*,则是此路径所有servlet起作用,如果是/servlet，那么就只对servlet起作用
		  	filter-pattern
		  	
		  	
		  	form:  action:请求的路径
		  	
		  	
		  	流
		  	1.响应字符流
		  	PrintWriter = respones.getWriter();
		  	2.响应字节流
		  	response.getOutputStream();
		  	
		  	
		  	
		  	
		  	生命周期
		  	1、创建servlet实例：
				在默认情况下Servlet实例是在第一个请求到来的时候创建，
				以后复用。如果有的Servlet需要复杂的操作需要载初始化时完成
				，比如打开文件、初始化网络连接等，可以通知服务器在启动的时候创建该Servlet的实例。
				
			2.一旦Servlet实例被创建，Web服务器会自动调用init(ServletConfig config)方法来初始化该Servlet。
			其中方法参数config中包含了Servlet的配置信息，比如初始化参数，该对象由服务器创建。
			
			servletConfig：专门获取配置文件的数据
			
			
			 一旦Servlet实例成功创建及初始化，该Servlet实例就可以被服务器用来服务于客户端的请求并生成响应。
			 	在服务阶段Web服务器会调用该实例的service(ServletRequest request, ServletResponse response)方法，
			 	request对象和response对象有服务器创建并传给Servlet实例。
			 	request对象封装了客户端发往服务器端的信息，response对象封装了服务器发往客户端的信息。
			 	
			 	
			 	
			 	//======================================
			 	Servlet生命周期分为三个阶段：

　　1，初始化阶段  调用init()方法

　　2，响应客户请求阶段　　调用service()方法

　　3，终止阶段　　调用destroy()方法

Servlet初始化阶段：

　　在下列时刻Servlet容器装载Servlet：

　　　　1，Servlet容器启动时自动装载某些Servlet，实现它只需要在web.XML文件中的<Servlet></Servlet>之间添加如下代码：

<loadon-startup>1</loadon-startup> 
　　　　2，在Servlet容器启动后，客户首次向Servlet发送请求

　　　　3，Servlet类文件被更新后，重新装载Servlet

　　Servlet被装载后，Servlet容器创建一个Servlet实例并且调用Servlet的init()方法进行初始化。在Servlet的整个生命周期内，init()方法只被调用一次
		  	
		  	
		  	
		  	Servlet何时被创建：

　　1，默认情况下，当WEB客户第一次请求访问某个Servlet的时候，WEB容器将创建这个Servlet的实例。

　　2，当web.xml文件中如果<servlet>元素中指定了<load-on-startup>子元素时，Servlet容器在启动web服务器时，将按照顺序创建并初始化Servlet对象。

　　注意：在web.xml文件中，某些Servlet只有<serlvet>元素，没有<servlet-mapping>元素，这样我们无法通过url的方式访问这些Servlet，这种Servlet通常会在<servlet>元素中配置一个<load-on-startup>子元素，让容器在启动的时候自动加载这些Servlet并调用init()方法，完成一些全局性的初始化工作
		  	
		  	
		  	
		  	
		  	
	
*/
}
