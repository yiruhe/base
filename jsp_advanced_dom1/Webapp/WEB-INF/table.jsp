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
			width:900px;
			margin:0px auto 0;
		
		}
		
		form{
			
			width:1200px;
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

	
	
		
		<form action="list" method="post">
		名字:		<input type="text" name="name" value="${dir.name}"/>
		成绩范围:	<input type="text" name="minScore" value="${dir.minScore}" /> -
				<input type="text" name="maxScore" value="${dir.maxScore}" />
		关键字查询: <input type="text" name="keyword" placeholder="关键字搜索-->名字/科目"  />		
				<select name="dirId">
					<option value="-1">----请选择----</option>
					<c:forEach items="${partName}" var="part">
						<option value="${part.departIndex}" ${dir.departmentId == part.departIndex ? "selected":""}>${part.departName}</option>
					</c:forEach>
				</select> 				
				<input type="submit" value="commit" />
	</form>
	<table id="table">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>department</th>
			<th>score</th>
			<th>departName</th>
		</tr>
		<c:forEach items="${message}" var="information" varStatus="s">
			<tr>
				<td>${information.id}</td>
				<td>${information.name}</td>
				<td>${information.department}</td>
				<td>${information.score}</td>
				<td>${information.departmentDirectory.departName}</td>
			</tr>
		</c:forEach>
	
	</table>
	
</body>
</html>