package expressionlanguage;

public class InstructionDemo {
/*
	
	//动作指令:
	<jsp:include page=”url” flush=”false|true”>子标签</jsp:include>
	Page:该属性用于指定被包含文件的相对路径.
	Flush:可选参数，用于设置是否刷新缓冲区，如果为true，则在当前页面输出使用了缓冲区的情况下，将先刷新缓冲区，然后再执行包含操作。
	//如果当前页面存在out 字符输出流,先清空缓存
	
	 Warning:被包含的页面中不要使用<html><body>标签，会破坏JSP页面结构。
	 
	 
	JSP转发标签<jsp:forward>
 	这个动作标签是请求转发标签，可以将当前页面的请求转发级其他Web资源，可以是JSP页面，HTML页面，Servlet等。并且当前页面可以不对请求进行处理
 	。语法如下:<jsp:forward page=”url”>子标签</jsp:forward>
	
	4.3 JSP参数标签<jsp:param>
	该标签可以作为其他标签的子标签，为其它标签传递参数。语法如下:<jsp:param name=”paramName” value=”paramValue”/>
	Name:用于设定参数名称.
	Value:用于设定对应参数的值.
	
	
	
	  4.4.1 <jsp:useBean>标签
		  用于在JSP页面中创建一个JavaBean实例，并通过属性设置将此实例存放在JSP指定范围内。语法如下:
		<jsp:useBean id=”变量名” scope=”page|request|session|application”{
		Class=”完整类名” type=”数据类型”  beanName=””}/>
		Id:用于定义一个变量名，JavaBean的代号名字，通过这个对它进行引用。
		Scope:设置JavaBean的作用范围，默认为page.
		Class:指定JavaBean的完整类名(包名与类名完全结合的方式)。
		Type:指定id属性定义的变量类型。
		BeanName:指定完整类名，不能与class同时使用.
		
		
		
		4.4.2 <jsp:setProperty>标签
		  用与对JavaBean属性赋值，但JavaBean的属性要提供setXXX()方法。语法如下:
		<jsp:setProperty name=”实例名” property=”*”|property=”属性名”|property=”属性名” param=”参数名”|property=”属性名” value=”值” />
		Name:指定JavaBean的引用名称.
		Property:指定JavaBean中的属性名。
		Param:指定JSP请求中的参数名，通过该参数可以将JSP请求参数赋给JavaBean的属性。
		Value:指定一个属性值。
		
		
		4.4.3 <jsp:getProperty>标签
		  <jsp:getProperty>用于获取JavaBean中的属性值，要求属性必须具有getXXX()方法。
		<jsp:getProperty name=”实例名” property=”属性名” />
		Name:指定某一范围的JavaBean实例的引用。
		Propertyl:指定JavaBean属性名称.
	
	*/
}
