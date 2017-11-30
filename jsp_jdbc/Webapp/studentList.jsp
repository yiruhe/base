<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="
	servletdemo.dao.implement.StudentImplement,
	servletdemo.domain.Student,java.util.List"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	*{
		padding:0;
		margin:0;
	}

	#table{
		border:1px solid red;
		width:800px;
		border-collapse:collapse;
		margin:60px auto;
	}
	td,tr,th{
		height:30px;
		padding:10px 20px;
		text-align:center;
		border:1px solid #666;
		
	}

</style>
</head>
<body>
		
		<%
		 List<Student> obj=(List<Student>)request.getAttribute("student");
		%>


		<a href="/student/input.jsp">插入信息</a>
		<table id="table">
			<tr>
				<th>id</th>
				<th>username</th>
				<th>department</th>
				<th>score</th>
				<th>edit</th>
			</tr>
			
	
			<c:forEach items="${student}" var="student"  varStatus="s">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.department}</td>
					<td>${student.score}</td>
					<td>
						<a href="/student/remove?id=${student.id}">删除</a>
						<a href="/student/input.jsp?id=${student.id}&name=${student.name}&department=${student.department}&score=${student.score}
						">编辑</a>
					</td>
				</tr>
			</c:forEach> 
		</table>

</body>
</html>