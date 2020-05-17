<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
	<h3>登录系统</h3>
	<form action="${pageContext.request.contextPath}/requestServlet_v1">
		用户名：<label><input type="text" name="username"></label><br>
		密码：<label><input type="password" name="password"></label>
		<input type="submit">
	</form>
</body>
</html>
