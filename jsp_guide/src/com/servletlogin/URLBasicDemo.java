package com.servletlogin;

public class URLBasicDemo {

	//eclipse的tomcat插件需要关联tomcat server
//	URL:统一资源定位符
	
	//为什么会有 "%" 查阅URL编码规范RFC3986可知,浏览器编码URL是将非
	//ASCII字符按照某种编码格式编码成16进制数字后将每个16进制表示的字节前面加上
	//"%";
	
	//请求:
	//客户端提交的参数的解码是在第一次调用request.getParameter时发生的
	//POST的提交的时候,浏览器会根据ContentType的Charset编码格式对表单的参数进行编码,然后提交到服务器
	//服务器在用相同的字符编码集进行解码
	
	//响应:
	//浏览器收到响应后将通过Content-Type的charset来解码,如果返回的
	//HTTP Header中Content-Type没有设置charset.那么将根据
	//HTML的<meta> 标签设置的charset来解码,如果都没有,就使用浏览器默认编码来解码
	
	
	//hhtp://baike.baidu.com/view/245.html
	
	//第一部分:protocol(协议)
	//第二部分:站点地址
	//3部分:目录
	//4：文件
	//各部分之间也用“/”符号隔开
	
	
	//servlet容器为javaWeb应用提供运行时环境,它负责管理Servlet和jsp的生命周期
	//以及共享数据
	
	//xml配置文件设置了中文,编码格式使用utf-8
	//http协议默认端口是80端口
	//我们访问的时候都是遵循与http端口的
	
	
	//tomcat 服务:开机自动启动tomcat
	//用command line ：
	//1.install service: service install  (dos)   
	//2.uninstall service:  service remove  (dos)
	
	
	//告诉tomcat从指定的路径去部署项目：
	
	//1.配置需要部署项目的路径(区分大小写)  //找到Tomcat根目录/conf/server.xml
		////找到server.xml的Host标签:
		//1):Context:表示上下文，当前项目环境
		//2):docBase:需要部署项目wab的根路径
		//3):path:上下文路径,多个存在不能相同
	
		//example：
//		<Context docBase="d:/...." path="上下文路径(访问资源的路径名)" />
	
	//访问资源====>>>>:
	// http://ip:port/contentPath/资源
	//	http://ip:port/contentPath/ps <--
	//<Context docBase="..." path="ps"/>  <--
	
	//-->!@!!多个Context的path名字不能一样
	
	
	
	//第二种方式:tomcat5.5开始推荐的
	//找到Tomcat根/conf/Catalia/localhost新建一个xml文件:比如abc.xml
	//<Context docBase="....." />
	//文件名就是上下文路径
}	
