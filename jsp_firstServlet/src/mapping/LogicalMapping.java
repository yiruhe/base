package mapping;

public class LogicalMapping {
	
	//servlet mapping
	
	//一个Servlet程序(WEB component),可以配置多个<url-pattern>,表示一个Servlet有多个资源名称
	
	//a servlet could more configuration of mapping
	
	//servlet的映射支持通配符映射(*);

	//第一种写法:/*任意资源都可以访问该servlet,/system/*:请求的资源必须/system/打头才可以访问
	//第二种： *. 拓展名，example  :比如:*.do请求资源必须以.do作为结尾才可以访问
	
	//5.在映射Servlet的时候,servlet-name的元素文本不能是default的
		//因为在Tomcat中存在一个叫做default的servlet,专门用于处理请求静态资源
		//Tomcat/conf/web.xml文件
	
	
	//Srevlet3.0对应javaEE6的规范,Tomcat7.*;
	//JavaEE6的规范是由tomcat7实现的
	
	//xml效率低,从Tomcat7开始使用注解来取代xml配置
	
	//xml.web ： matedata-compelet web.xml文件根元素中存在该属性,表示是否忽略扫描WEB组件注解
	//="true":
	//="false";
	
	
	//	@WebServlet(value={"m1"},initParams={
//			@WebInitParams(name="encoding",value="UTF-8")

//		})
	
	
	//xml和注解的优缺点:
		//XML : 优点:XML配置很清晰,很直观,维护性较高(因为和JAVA代码相分离)
//				缺点:xml配置导致配置文件臃肿,开发效率低

		//注解 : 优点:开发效率高,配置文件不臃肿,也方便快速定位
	
	
	//servlet的线程不安全问题:
		//cause of:servlet是单例的,Servlet中的非static的成员变量只有一份,多个客户端,好比多个线程,都访问的是同一个空间
		//有可能这个线程才赋值给这个servlet,但是这个线程又睡着了,第二个线程就又进入servlet又把servlet的值改变了,这就有可能
		//两边同时取出相同的数据,又一边不时自己想要的
	
	//解决方案:
		//1.让当前Servlet实现javax.servlet.SingleThreadModel接口
		//2.在Servlet中不要使用成员变量,使用局部变量
			//每个用户,每一个请求都会调用Service方法,而局部变量在service方法中,每一次都是新的空间
	
			//struts2是线程安全的,因为每次都是一个新的servlet
	
	//Http协议是无状态连接,服务端不知道上一次是哪一个客户端请求了自己.
	//无状态连接带来的问题:
		//在一次会话总,我们可以查看对个资源,每个资源都会先发送请求,
		//再响应,每次请求都是客户端发出的
	//也就是说,在一次会话中，多个请求无法共享数据,无法跟踪用户的会话信息
	
}	
