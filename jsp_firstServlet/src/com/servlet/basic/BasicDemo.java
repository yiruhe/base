package com.servlet.basic;

public class BasicDemo {
	
	//Tomcat是servlet的容器--->是对servlet的一个实现
	
	
	//Tomcat是Servlet的容器,会负责servlet对象的生命周期,和方法调用

	//生命周期:
	//Servlet的生命周期:创建对象,初始化操作,运行操作,销毁操作
	//Tomcat管理了生命周期,Servlet对象整个过程都是有Tomcat来管理的
	//Servlet的创建,初始化,运行,销毁的行为都是Tomcat来负责调用
	
	//生命周期:
	//在Web生命周期中Tomcat启动->Tomcat关闭，Servlet是单例的
	//构造器:在服务端第一次被请求的时候初始化
	
	//init：constructor完毕后也会被调用一次
	//service：每一次请求都会执行
	//destroy:正常关闭Tomcat才会执行(该方法不一定被执行)
	
	//注意:
	//Servlet类的构造器必须使用public修饰   
	//servlet类必须有一个无参数构造器
	
	//！！cause of:底层创建servlet对象:class.newInstance()  ---->necessary:无参数构造器
	//Notes:保证Servlet必须有一个公共的无参构造器,方便Tomcat底层instantiation
	
	
	
	
	//第一次请求:
		//1.解析请求信息 (/context/test)  上下文路径(context),资源名(test)
		//2.根据上下文路径(context)去tomcat根路径根/conf/找到server.xml文件
			//获取所有的<Context/>元素,在判断哪一个<Context/>元素的path值为test,
			//再根据path对应的docBasc属性值,该属性就是当前访问的根路径(D:/.....)
		//3.再从当前项目的根路径下的WEB-INF目录中,读取web.xml文件,
		//4.获取web.xml中所有的<url-pattern>元素，判断是否存在test路径
		//5.在根据该test资源,获取servlet-name,根据这个名称找到类的全限定名
	
		//6.根据Servlet的权限定名,使用反射来调用构造器-->创建对象(并不代表一定是类的全限定类名，这是猜测)
				//比如:Servlet obj = Class.forName("全限定类名(qualified name)");
	
		//7.创建ServletConfig对象,在调用init方法
		//8.创建request,response对象,再使用servlet对象,调用servlet方法
		//9。在service方法中对客户端做响应
	
	//非第一次响应:
		//前5步相同,
		//6.从Tomcat的Servlet实例缓存池中取出对应的对象
		//7.创建request,response对象,在使用servlet对象调用service方法
		//8.做出响应
		
	
	//缓存池类似Map集合,根据名字找对象,没有就去创建,有就获取
	
	
	//ServletConfig接口:表示Servlet的信息配置对象
	//获取的init参数来自这个servlet的配置信息(每一个servletConfig都有自己的一个config实例)
	//servletConfig的实例由tomcat创建
	//getServletName：获取servlet名字<servlet-name>里的
	
	
	
}
