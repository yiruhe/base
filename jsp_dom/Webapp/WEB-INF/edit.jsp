<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	*{margin:0;padding:0;}
	#form{
		width:300px;
		margin:60px auto;
	}
	
	form p{
		padding:5px;
	
	}
	
	input,select{
		float:right;
		
		
	}
	
	.commit{
	padding:0 60px;
	font-size:17px;
	background:#666;
	border:none;
	color:#FFF;
	}
	
</style>
</head>
<body>
	
	<form action="list?cmd=add"  method="post" id="form">
		<input type="hidden" name="id" value="${message.id}" />
		<p>user:<input type="text" name="name" value="${message.name}"/></p>
		<p>department:<input type="text" name="department" value="${message.department}" /></p>
		<p>score:<input type="text" name="score" value="${message.score}" /></p>
		<p>depar_Name:<select name="departmentName">
			<c:forEach items="${departName}" var="depart" >
				<option value="${depart.departIndex}" ${message.departmentDirectory.departIndex == depart.departIndex ? "selected":""}>${depart.departName}</option> 
			</c:forEach>
		</select></p>
		<p>commit:<input class="commit" type="submit" value="commit" /></p>
	</form>

</body>
</html>