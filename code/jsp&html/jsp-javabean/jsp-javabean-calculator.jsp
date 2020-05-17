<%@ page language="java" pageEncoding="UTF-8"%>
<%--使用CalculatorBean --%>
<jsp:useBean id="calcBean" class="com.isleslie.mvc.jsp_javabean.CalculatorBean"/>

<%--接收参数
     ！！！不是jsp应该干的活！！！
     假如我要进行请求参数的验证？？？
     ....
     ....
--%>
<jsp:setProperty name="calcBean" property="*"/>

<%
	//使用CalculatorBean进行计算
	calcBean.calculate();
%>
<!DOCTYPE HTML>
<html>
<head>
	<title>使用【jsp+javabean开发模式】开发的简单计算器</title>
</head>

<body>
<br/>
计算结果是：
<jsp:getProperty name="calcBean" property="firstNum"/>
<jsp:getProperty name="calcBean" property="operator"/>
<jsp:getProperty name="calcBean" property="secondNum"/>
=
<jsp:getProperty name="calcBean" property="result"/>

<br/><hr> <br/>
<form action="jsp-javabean-calculator.jsp" method="post">
	<table border="1px">
		<tr>
			<td colspan="2">简单的计算器</td>
		</tr>
		<tr>
			<td>第一个参数</td>
			<td><input type="text" name="firstNum"></td>
		</tr>
		<tr>
			<td>运算符</td>
			<td><select name="operator">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select></td>
		</tr>
		<tr>
			<td>第二个参数</td>
			<td><input type="text" name="secondNum"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="计算"></td>
		</tr>
	</table>
</form>
</body>
</html>