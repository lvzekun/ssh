<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	String url = "jdbc:sqlserver://localhost:1433;databaseName=db_Park;user=sa;password=123";//sa身份连接

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
    
    <title>My JSP 'showyuamount.jsp' starting page</title>
    
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

		<%
			request.setCharacterEncoding("UTF-8");
			//response.setContentType("textml;charset=UTF-8");//设置传输编码

			String parklotname = request.getParameter("parklotname");
			//String parklotname=new String(str_parklotname.getBytes("ISO-8859-1"),"utf-8"); //转码UTF8

			//获取停车场地址
			String parklotaddress=null;
			ResultSet rs4 = null;
			String sql4 = "select parklotaddress from Parklotinfo where parklotname = "
					+ "'" + parklotname + "'";
			rs4 = stmt.executeQuery(sql4);
			while(rs4.next()){
			parklotaddress = rs4.getString("parklotaddress");}
		
			//计算空余车位
			int parklotamount = 0;
			int usedamount = 0;
			ResultSet rs2 = null;
			String sql2 = "select parklotamount from Parklotinfo where parklotname = "
					+ "'" + parklotname + "'";

			rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {
				parklotamount = rs2.getInt("parklotamount");
				//out.println(sql2);
			}
			ResultSet rs3 = null;
			String sql3 = "select count(*) as usedamount from Inoutinfo where parklotname = "
					+ "'" + parklotname + "'";
			//out.println(sql3);
			rs3 = stmt.executeQuery(sql3);
			while (rs3.next()) {
				usedamount = rs3.getInt("usedamount");
				// out.println(usedamount);
			}
			int yuamount = parklotamount - usedamount;
		%>
		<br> <br> <br>
		<table border="1" cellspacing="0" cellpadding="4">
			<tr>
				<th>名字</th>
				<th>地址</th>
				<th>空车位数量</th>
			</tr>
			<tr>
				<td><%=parklotname%></td>
				<td>
					<%=parklotaddress %>
				</td>
				<td><%=yuamount%></td>


			</tr>

		</table>

	</center>
</body>
</html>
