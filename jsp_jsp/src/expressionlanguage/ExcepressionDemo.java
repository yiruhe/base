package expressionlanguage;

public class ExcepressionDemo {
	
	
	//属性是由Getter和Setter方法决定的
	
	//当EL表达式获取值的时候,就是调用getter方法
	//${user.username}  == ${user.getUsername()}
	
	//EL:表达语言
	//目的:从作用域中获取指定属性名的共享数据
	
	//语法:${属性名} 属性名没有引号
	
	//没有EL表达式时:
	//<%=pageContext.findAttribute("msg")==null?"":pageContext.findAttribute("msg")%>

	//EL表达式:
	//${msg}
	//EL从作用域中查询指定属性名的共享数据,是有查找顺序的
	//按照顺序次序从page,request,session,appliaction寻找共享数据
	
	//EL中的隐式对象
//	  ${内置对象.}
//	
	
	
//	11大EL隐式对象中，其中一个是表示自身对象pageContext外，其余都是表示的Map结构
//	请求参数
//
//	   1. param 包含所有的参数的Map可以获取参数返回String    //同：ServletRequest.getParameter(String name)
//
//	   2. paramValues 包含所有参数的Map,可以获取参数的数组返回String[]  //同：ServletRequest.getParameterValues(String name)
//
//	头信息
//
//	   3. header 包含所有的头信息的Map。可以获取头信息返回String   //同：ServletRequest.getHeader(String name)
//
//	   4. headerValues 包含所有的头信息的Map。可以获取头信息数组返回String[]  //同：ServletRequest.getHeaders(String name)
//
//	Cookie
//
//	   5. cookie包含所有cookie的Map,key为Cookie的name属性值 //同：ServletRequest.getCookies( )
//
//	初始化参数
//
//	   6. iniParam 包含所有的初始化参数的Map，可以获取初始化的参数.  	同：ServletRequest.getInitParameter(String name)
//
//	作用域
//
//	   7. pageScope 包含page作用域内的Map.   //取得Page范围属性名称中的值
//
//	   8. requestScope 包含request作用域内的Map //取得Request范围属性名称中的值
//
//	   9. sessionScope 包含session作用域内的Map	取得Session范围属性名称中的值
//
//	  10. applicationScope 包含application作用域内的Map 取得Application范围属性名称中的值
//
//	  11. pageContext 包含页面内的变量的Map，包含request，response，page，application，config等所有的隐藏对象  //表示JSP中的PageContext
	
	//获取上下文路径:
//	<%= request.getContextPath %>
	
	//EL中的内置对象:
	//Tomcat7开始El表达式可以调用方法
//	${pageContext.getRequest().getContextPath()}
//	${pageContext.request.contextPath}
	
		
	
	//单独的scope--> El的四大隐式对象
	//与作用范围有关的EL隐含对象包含有：pageScope、requestScope、sessionScope和applicationScope
	//只能获取对应scope的数据,获取不到就为空
	
	//获取对象中的属性: tomcat7开始可以调用方法
	//req.setAttribute("p",person);
//	方式1:使用. :${p.username}
//	方式2:使用[] :${p["username"]}
//	3${p.getUsername()}
	//JSTL:准备
//		1.加入jar包  standard.jar,jst.jar
//		2.通过tomcat的tablib指令,引入标签库
//		<%@ taglib uri="xxxx" prefix=""%>
//	
//		JSTL标签库使用方法:
//		标签库                         URI                                      前缀     			使用模式
//		核心标签库                  http://java.sun.com/jstl/core         		c         	<c:tagname…>
//		国际化标签(I18N)        http://java.sun.com/jstl/fmt   		fmt       	<fmt:tagname…>
//		SQL标签库                 http://java.sun.com/jstl/sql          		sql       	<sql:tagname…>
//		XML标签库                http://java.sun.com/jstl/xml         		x        	<x:tagname…>
//		函数标签库                  http://java.sun.com/jstl/functions    		fn      	<fn:tagname…>
	
	//条件:  满足条件,就输出标签
	//<c:if test="${num>20}">num>20</c:if>
	//把判断结果存储在一个变量中
	//<c:if test="${num > 20}" var="result" scope="page"/>
	
	//多条件:
	//<c:choose /> 标签  类似于java的switch
	
//	<c:choose>
////		<c:when test="${num>20}">num大于20</c:when>
////		<c:when test="${num<20}">num小于20</c:when>
//		<c:otherwise>num等于20</c:otherwise>
//	</c:choose>
	
	//以往开发的时候所引入的jar包:
		//servlet-api
		//jstl
		//standard
		//el-api
		//jsp-api

	//比较的是值   ${'1' == 1}
	//> (gt)
	//>= (ge)
	//<	(lt)
	//<= (le) less and equal
	//!= (ne) not equal
	//== (eq) equal
	
	//空判断: ${empty c}
	
	
	
	
	
}
