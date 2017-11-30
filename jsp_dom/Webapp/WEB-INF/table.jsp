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
		
		#table{
			border-collapse:collapse;
			border:1px solid #666;
			width:700px;
			margin:20px auto;
		
		}
		
		th,td{
			border:1px solid #666;
			text-align:center;
			padding:15px;
			
		}

	</style>
</head>
<body>

	
	<a href="/show/list?cmd=edit">添加</a>
	<table id="table">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>department</th>
			<th>score</th>
			<th>departName</th>
			<th>edit</th>
		</tr>
		<c:forEach items="${message}" var="information" varStatus="s">
			<tr>
				<td>${information.id}</td>
				<td>${information.name}</td>
				<td>${information.department}</td>
				<td>${information.score}</td>
				<td>${information.departmentDirectory.departName}</td>
				<td>
					<a href="/show/list?cmd=remove&id=${information.id}">删除</a>
					<a href="/show/list?cmd=edit&id=${information.id}">编辑</a>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	
</body>
</html>