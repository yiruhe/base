<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	
		<form action="shopping" method="post">
			<select name="commodity">
				<option>iphone6</option>
				<option>iphone5</option>
				<option>iWatch</option>
			</select>
			<input type="text" name="quantity" />
			<input type="submit"  value="buy" />
		</form>
		<a href="/show/showCart.jsp">去购物车</a>
</body>
</html>