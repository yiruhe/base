package jsp;

public class Basic {
	
	//tomcat会把所有以.jsp结尾的资源都交给JspServlet来处理
	
	//

	//流程:
	//hello.jsp --> hello_jsp.java --->hello_jsp.class
	
	//第一次请求JSP页面时:
	//1.将jsp页面转化成一个JSP页面实现类
	//2.转换成功,容器将会编译Servlet类.之后转换成字节码
	
	//对于同一个JSP页面的后续请求,Servelt容器会查看JSP页面自从
	//最后一次转换以来是否修改过,如果修改过,就会重新转换,
	//重新编译,并执行
	
	//如果没有就执行已存在的JSP Servlet
	
	
	
	
	//<%-- jsp comment --%>
	
	
	//<% java code       %>  //会被编译到jsp类service方法中
	
	//<%=expression %>  //输出  ==  print( expression );
	
	//<%! java code %>  //其中的语句会原封不动的翻译到类成员变量和方法时
	
	
	//jsp的标准指令:设定jsp网页整体配置信息
	//特点:
		//1.并不向客户端产生任何输出
		//2.指令只在jsp整个文件范围内有效
		//3.位翻译阶段提供全局信息
	//每一个jsp都有一个page指令,一般放在第一行
	
	//jsp的三大指令:
		//page
		//include
		//taglib
	
	//jsp中编写指令的语法:
		//<%@ 指令 属性="属性值" %>
		
	//page指令:表示的jsp页面相关的配置信息(language目前只支持Java)
//		常用属性:
//		language: 表示在jsp中编写的脚本的语言
//		contentType: 表示jsp输出的MIME类型和编码
//			等价于 response.setContentType("text/xml;charset=utf-8");
	
//		pageEncoding:表示jsp输出的编码:
			//response.setCharacterEncoding("utf-8");
	
	
	
	//若contentType和pageEncoding共存,以pageEncoding为主
	//只存在pageEncoding时默认MIME格式是text/html
	
	
	
	
//	 isThreadSafe 属性控制由 JSP 页面生成的 servlet 是允许并行访问（默认），还是同一时间不允许多个请求访问单个 servlet 实例（isThreadSafe="false"）。使用 isThreadSafe 属性时，可以采用下面两种形式：
//			 <%@ page isThreadSafe="true" %> <%--Default--%>
//			 <%@page isThreadSafe="false" %>
//
//			 遗憾的是，阻止并发访问的标准机制是实现 SingleThreadModel接口。尽管在早期推荐使用 SingleThreadModel 和 isThreadSafe="false"，但最近的经验表明 SingleThreadModel 的设计很差，使得它基本土毫无用处。因而，应该避免使用 isThreadSafe，采用显式的同步措施取而代之。
	
}
