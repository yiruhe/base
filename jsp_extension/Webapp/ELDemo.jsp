<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true"
	isErrorPage="true"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		从指定共享的作用域获取数据${}
  	--%>
	
	<%
		request.setAttribute("msg","requestValue");
		session.setAttribute("msg","sessionValue");
		pageContext.setAttribute("msg","pageValue");
		application.setAttribute("msg","applicationValue");
	%>
	
	<h2>request:<%=request.getAttribute("msg") %></h2>
	<h2>session:<%=session.getAttribute("msg") %></h2>
	<h2>pageContext:<%=pageContext.getAttribute("msg") %></h2>
	<h2>application:<%=application.getAttribute("msg") %></h2>
	
	<%--
		按次序寻找:
		1:pageContext
		2:request
		3:session
		4:application
	 --%>
	<h2>find:<%=pageContext.findAttribute("msg1")==null?"":pageContext.findAttribute("msg1")%></h2>
	
	<!-- 和find原理相同 -->
	<h2>$:${msg}</h2>
	获取值的方式:
	\${user.name}方式1:
	<h3>类:${user.name}</h3>
	\${user["name"]}方式:
	<h3>类:${user["name"]}</h3>
	\${user.getName()}方式:
	<h3>类:${user.getName()}</h3>
	
	获取数组:
	<h3>${user.hobby[1]}</h3>
	
	获取list
	方式1:
	<h3>${user.list[0]}</h3>
	
	获取map:
	<h3>${user.map.score }</h3>
	<h3>${user.map["www.baidu.com"] }</h3>
	
	
	
	
	<%--
		查找jar包:
			apache-tomcat-7.0.63\webapps\examples\WEB-INF\lib
	
	 --%>
	
	
	
	<h2>user</h2>
	

</body>
</html>