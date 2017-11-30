<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	*{
		margin:0;
		padding:0;
	}
	
	form{
		width:300px;
		
		margin:60px;
	
	}
	
	input{
		float:right;
	}
	
	p{height:30px;}

</style>
</head>
<body>

		
		<%-- <%=request.getParameter("name") %> --%>
		<form action="/student/save" method="post">
			<!-- 记得传入id参数 -->
			<input type="hidden" name="id" value="${param.id}"/>
			<p>user:<input type="text" name="username" value="${param.name}"/></p>
			<p>department:<input type="text" name="department" value="${param.department}" /></p>
			<p>score:<input type="text" name="score" value="${param.score}" /></p>
			<p>score:<input height="40" type="submit" value="commit" /></p>
		</form>
</body>
</html>