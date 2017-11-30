<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		jstl.jar 接口
		standar.jar 实现
		jsp-api  自定义标签库
	 --%>
	 
	 <%
	 	request.setAttribute("message",null);
	 
	 %>
	 
	<c:if test="${1<2}">2</c:if>
	
	
		如果属性(value)指定的表达式或者对象为null,那么将输出这个defalut value部分的值.为空,那么输出标签内的值
	
	<c:out value="${message}" >default value</c:out>
	//
	<c:out  value="${message}"  escapeXml="false">
		<p>Tom is taller than you</p>
	</c:out>

	set
	//给scope设置属性值
	<c:set var="beautiful" value="more" scope="page"/>
	<c:out value="${beautiful}" />

	<%-- <c:set target="${user}" property="name" value="Tom"/> --%>
	<p>获取上面对象的值:${user.name}</p>
	
	remove:
	<c:remove var="beautiful" scope="page" />
	<p>remove后===${beautiful}</p>
	
		
	catch:
	<c:catch var="exception">
		${1**}
	</c:catch>
	<p>获取exception:${pageScope.exception}</p>
	
	if:
	<c:if test="${1<0}" var="result"  scope="page">
		if----->hello
	</c:if>
	<p>获取if存入的值:${result}</p>

	
	choose:
	<c:set var="num" scope="page" value="admin" />
	<c:choose>
		<c:when test="${num == 'guest'}">
			<c:out value="choose--->guest"/>
		</c:when>
		<c:when test="${num == 'admin'}">
			<c:out value="choose--->admin"/>
		</c:when>
	</c:choose> 
	
	forEach:
	<c:forEach var="i" begin="1" end="10" step="1">
		${i}
	</c:forEach>
	
	<%
	
		pageContext.setAttribute("list",java.util.Arrays.asList("a","b","c"));
		
	%>
	
	<c:forEach var="separate" items="${list}" varStatus="s">
		<p>lis----|>${separate}----->
			第${s.count}次循环----->当前计数器的值:${s.index}
			---->是否是第一次:${s.first}--->是否是最后一次:${s.last}
		</p>
	</c:forEach> 
	
	forTokens:
	<c:forTokens var="value" items="c|c++|java,html|css" delims="|,">
		<p>${value}</p>
	</c:forTokens>
	
	
	import: //把数据存入thisPage中
	<c:import url="http://www.baidu.com" charEncoding="utf-8" varReader="reader"/>
	import--------------------->${thisPage}
	reader--------------->${reader}
	
	url:
	<c:url var="url" value="/xxxx.jsp" context="/my" />
	<p>url:${url}</p>
	//指定上下文路径和文件
	<c:redirect url="/ELDemo.jsp" context="/expression">
		<c:param name="username" value="name" />
	</c:redirect>
	
</body>
</html>