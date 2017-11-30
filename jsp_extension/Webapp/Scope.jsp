<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		pageContext.setAttribute("message","pageValue");
		request.setAttribute("message","requestValue");
		session.setAttribute("message","messageValue");
		application.setAttribute("message","applocationValue");	
		//cookie
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("username","keke");
		
		//添加cookie
		response.addCookie(cookie);
		
		
		
		
	%>
	${param.msg}
	==:
	<p>${1 == 1}</p>
	eq:
	比较的是值
	
	<p>${1 == "1"}</p>
	<p>${1 le "1"}</p>
	
	
		
	pageScope:	只获取当前作用域的值
	<p>${pageScope.message}  ==  request.getAttribute("message")</p>  
	sessionScope 
	<p>${sessionScope.meassage}</p>
	application
	<p>${applicationScope.meassage}</p>
	
	//注意这是EL表达式的隐式对象  //这两个方法相同
	<p>${pageContext.getRequest().getContextPath()}</p>
	<p>${pageContext.request.contextPath }</p>

	//param
	<p>${param.username}</p>
	
	//paramValues //根据属性返回数组
	<p>${paramValues.username[0]}</p>
	
	//cookie
	<p>==${cookie.username.value}</p>

	//header读取请求头
	<p>${header["User-Agent"]}</p>
	
	//headerValues
	<p>${headerValues}</p>		

</body>
</html>