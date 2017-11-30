package com.servlet.basic;

public class DeploymentBasicDemo {
	
	//web.xml一定要放在web-inf下面
	//cause of(detail):
		//Tomcat文件夹下的conf/context.xml中自动monitored的目录文这个目录
	
	//web-inf
		//-新建lib
		//-新建classes
		//web.xml
	
	//把项目部署在虚拟主机中
	
	//<Context>元素的属性: 
	//path:指定访问该Web应用的URL入口。 
	//docBase:指定Web应用的文件路径，可以给定绝对路径，也可以给定相对于<Host>的appBase属性的相对路径，
			//如果Web应用采用开放目录结构，则指定Web应用的根目录，如果Web应用是个war文件，则指定war文件的路径。(指定项目所在地址) 
	//reloadable:如果这个属性设为true，tomcat服务器在运行状态下会监视在WEB-INF/classes和WEB-INF/lib目录下class文件的改动，如果监测到有class文件被更新的，服务器会自动重新加载Web应用。
}	
