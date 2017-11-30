package basic;

public class Basic{
	
	//客户化的Jsp标签的作用

    //注意，在编写标签之前，必须把tomcat\lib中的jsp-api.jar文件配置在CLASSPATH中才可以；
	
	//1.创建标签处理类
	//Servlet在编译JSP网页时,如果遇到自定义标签,就会调用这个标签的处理类
	
	//TagSupport,bodyTagSupport类
	
	//	<t:test> doStartTag() //Servlet容器遇到自定义标签的起始标志时就会调用该方法
	//		test
	//	</t:test> doEndTag()  //Servlet容器遇到自定义标签的结束标志时就会调用该方法
	
	//2.创建标签的描述文件 后缀: .tld
		//这个文件必须定义在WEB-INF下面
			
	//<body-content></body-content>中可以写入的参数有四种：

	//① empty

	//即标记体为空

	//② scriptless

	//这个标记不能有脚本元素，但可以有模板文本和EL， 还可以是定制和标准动作

	//③ tagdependent

	//标记体要看做是纯文本，所以不会计算EL，也不会出发标记/动作

	//④ JSP

	//能放在JSP中的东西都能放在这个标记体中
	
		

	
	
	
	//使用
	
}