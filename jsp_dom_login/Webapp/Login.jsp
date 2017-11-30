<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//销毁session对象
		request.getSession().invalidate();
	
	%>
	
	<span style="color:red;">${tips}</span>
	<form action="verify" method="post">
		用户名:<input type="text" name="username" /><br />
		密&emsp;码:<input type="text" name="password" /><br />
		验证码:<input type="text" name="verify" /> <img src="progress" id="verify" />
			<a href="javascript:change()">看不清换一张</a>
		<input  type="submit" value="login" />
	</form>
	
	<script>
	
		function change(){
			
			
			//如果请求的资源不同,不再发送请求
			document.getElementById("verify").src = "progress?"+new Date().getTime();
		}
	
	</script>
</body>
</html>