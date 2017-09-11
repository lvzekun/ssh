<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=db_Park;user=sa;password=123";//sa身份连接

	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	con = DriverManager.getConnection(url);

	String SQL = "SELECT * FROM Parklotinfo";
	stmt = con.createStatement();
	rs = stmt.executeQuery(SQL);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>停车场</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body bgcolor="#ccd9ff">
	<center>
		停车场 <br> <br> <br>
		<form action="showyuamount.jsp" method="post">
			<select name="parklotname" id="parklotname" style="width: 200px">

				<%
					ResultSet rs1 = null;
					String sql1 = "select * from Parklotinfo";
					stmt = con.createStatement();
					rs1 = stmt.executeQuery(sql1);
					while (rs1.next()) {
						out.println("<option  value=" + rs1.getString(1) + ">"
								+ rs1.getString(1) + "</option>");
					}
					rs1.close();
				%>
			</select> <input type="submit" value="查询">
		</form>
	</center>
</body>
</html>
