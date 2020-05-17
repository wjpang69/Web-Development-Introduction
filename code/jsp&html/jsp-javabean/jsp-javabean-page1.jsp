<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>分离JavaBean Page1</title>
</head>
<body>
	<jsp:useBean id="queryBean" class="com.isleslie.mvc.jsp_javabean.QueryBean"/>
	<%
		out.print(queryBean.query());
	%>
</body>
</html>
