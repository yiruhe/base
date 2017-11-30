<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<style>
		*{
			margin:0;
			padding:0;
		}
		
		table{
			border:1px solid red;
			width:500px;
			border-collapse:collapse;
		}
		
		tr,td,th{
			border:1px solid red;
			text-align:center;
		
		}
	
	</style>
<body>

	${CART_IN_SESSION.commodity}
	<table>
		<tr>
			<th>name</th>
			<th>数量</th>
			<th>价格(单个)</th>
			<th>编辑</th>
		</tr>
		<c:forEach items="${CART_IN_SESSION.commodity}" var="commodity">
			<tr>
				<td>${commodity.name}</td>
				<td>${commodity.quantity}</td>
				<td>${commodity.price}</td>
				<td>
					<td>
						<a href="shopping?cmd=delete&id=${commodity.id}">删除</a>
					</td>
				</td>
			</tr>
		</c:forEach>
		<tr colspan="5">
			总金额:${CART_IN_SESSION.countTotalPrice}		
		</tr>
	</table>
</body>
</html>