<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>查询系统</title>
</head>
<body>
	<%
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		    //注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/homework","root","123456789");
			//预编译SQL
			String sql = "select * from goods";
			pstmt = conn.prepareStatement(sql);
			//执行SQL
			rs = pstmt.executeQuery();
			while(rs.next()){
			    out.print("=================================<br>");
			    out.print("id：" + rs.getInt(1));
				out.print("name：" + rs.getString(2));
				out.print("money：" + rs.getDouble(3) + "<br>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		    try {
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch (Exception e){
		        e.printStackTrace();
			}
		}
	%>
</body>
</html>
