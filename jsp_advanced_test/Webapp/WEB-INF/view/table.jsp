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


	<form action="list" method="post">
		名字:<input type="text" name="name" />
		成绩:<input type="text" name="minScore" />
		--<input type="text" name="maxScore" />
		<select name="engineerId">
			<option value="-1">----请选择----</option>
			<c:forEach items="${engineerList}" var="engineer">
				<option value="${engineer.engineerId}">${engineer.engineerName}</option>
			</c:forEach>
		</select>
		<input type="text" placeholder="搜索名字和科目" name="keyword" />
		<input type="submit" value="commit" />
	</form>
	<table>
		<tr>
			<th>name</th>
			<th>department</th>
			<th>score</th>
			<th>engineer_id</th>
		</tr>
			<c:forEach items="${message}" var="student">
				<tr>
					<td>${student.name}</td>
					<td>${student.department}</td>
					<td>${student.score}</td>
					<td>${student.engineerDir.engineerName}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>