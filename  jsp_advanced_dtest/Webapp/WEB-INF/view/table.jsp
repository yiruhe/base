<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		table{
			margin:60px auto;
			width:900px;
			border:1px solid #666;
			border-collapse:collapse;
		}
		
		td,tr,th{
			border:1px solid #666;
			padding:0 40px;
			text-align:center;
		}
		
	</style>
</head>
<body>


	<a href="list?cmd=edit">添加</a>
	<table>
		<tr>
			<th>name</th>
			<th>department</th>
			<th>score</th>
			<th>engineer_id</th>
			<th>edit</th>
		</tr>
			<c:forEach items="${message}" var="student">
				<tr>
					<td>${student.name}</td>
					<td>${student.department}</td>
					<td>${student.score}</td>
					<td>${student.engineerDir.engineerName}</td>
					<td>
						<a href="list?cmd=delete&id=${student.id}">删除</a>
						<a href="list?cmd=edit&id=${student.id}">编辑</a>
					</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>