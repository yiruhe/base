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
	<script>
	
		function currentPage(page){
			
			if(page != undefined){
				
			document.getElementById("currentPage").value = page;
			
			document.getElementById("pageItem").value = document.getElementById("pageItems").value;
			
			}
			
			document.forms[0].submit();
		}
	
	
	</script>
</head>
<body>

	
	<form action="list" method="post">
			<input type="hidden" name="currentPage" id="currentPage" />
			<input type="hidden" name="pageItem" id="pageItem" />
		名字:<input type="text" name="name" value="${userData.name}" />
		成绩:<input type="text" name="minScore" value="${userData.minScore}" />
		--<input type="text" name="maxScore" value="${userData.maxScore}" />
		<select name="engineerId">
			<option value="-1">----请选择----</option>
			<c:forEach items="${engineerDir}" var="engineer">
				<option value="${engineer.engineerId}" ${engineer.engineerId == userData.engineerId ? "selected":""}>${engineer.engineerName}</option>
			</c:forEach>
		</select>
		<input type="text" placeholder="搜索名字和科目" name="keyword" value="${userData.keyWord}" />
		<input type="submit" value="commit" />
	</form>
	<table>
		<tr>
			<th>name</th>
			<th>department</th>
			<th>score</th>
			<th>engineer_id</th>
		</tr>
			<c:forEach items="${pageSet.data}" var="student">
				<tr>
					<td>${student.name}</td>
					<td>${student.department}</td>
					<td>${student.score}</td>
					<td>${student.engineerDir.engineerName}</td>
				</tr>
			</c:forEach>
		<tr>
			<td colspan="4">
				<a href="javascript:currentPage(1)">首页</a>
				<a href="javascript:currentPage(${pageSet.previousPage})">上一页</a>
				<c:forEach begin="${pageSet.beginIndex}" end="${pageSet.endIndex}" var="index" >
					<c:if test="${pageSet.currentPage == index}">
						<span style="color:red;">${index}</span>
					</c:if>
					<c:if test="${pageSet.currentPage != index}">
						<a href="javascript:currentPage(${index})">${index}</a>
					</c:if>
				</c:forEach>
				<a href="javascript:currentPage(${pageSet.nextPage})">下一页</a>
				<a href="javascript:currentPage(${pageSet.endPage})">末页</a>
				总共${pageSet.totalPage}条数据,第${pageSet.currentPage}/${pageSet.endPage}页
			
				<select onchange="currentPage(1)" id="pageItems">
					<c:forEach items="${pageSet.pageListItems}" var="pageItem">
						<option ${pageSet.pageSize == pageItem ? "selected":""}>${pageItem}</option>					
					</c:forEach> 
				</select>
			
			</td>	
		</tr>
	</table>
</body>
</html>