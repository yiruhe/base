<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.message{
		color:red;
	}
</style>
</head>
<body>
	
	
	<p class="message">${requestScope.message}</p>
	<form action="load" method="post" enctype="multipart/form-data">
		<p>user:<input type="text" name='user' /></p>
		<p>password:<input type="text" name="password" /></p>
		<p>file:<input type="file" name="file" /></p>
		<p>file:<input type="file" name="file1" /></p>
		<input type="submit" value="commit" />
	</form>
</body>
</html>