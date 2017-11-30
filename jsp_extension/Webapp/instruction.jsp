<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="top.jsp" />
	
	
	<%-- <jsp:forward page="/Scope.jsp">
		<jsp:param name="msg" value="hello" />
	</jsp:forward> --%>
	
	
	<jsp:useBean id="user" scope="page" class="expression.user.User"></jsp:useBean>
	
	<jsp:setProperty name="user" property="name" value="test"/>
	${user.name}
	<p><jsp:getProperty name="user" property="name" /></p>
</body>
</html>