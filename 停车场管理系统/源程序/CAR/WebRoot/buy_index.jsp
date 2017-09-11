<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	/* 	width: 500px; */
}

th, td {
	border: solid #333 1px;
	height: 20px;
}

div {
	text-align: center;
}
</style>
</head>
<body>
	管理员登陆成功
	<div>
		<a href="../Login.jsp"><font color=blue>退出并回到首页</font></a>
	</div>
	<p />
	<div>
		<a href="AddParkBuyInfo.jsp"><font color=blue>增加购买信息</font></a>
	</div>
	<p />
	<table>
		<tr>
			<td><font color=red>编号</font></td>
			<td><font color=red>买家姓名</font></td>
			<td><font color=red>买家电话</font></td>
			<td><font color=red>买家性别</font></td>
			<td><font color=red>买家身份证号</font></td>
			<td><font color=red>单元号</font></td>
			<td><font color=red>买家车牌号</font></td>
			<td><font color=red>车位编号</font></td>
			<td><font color=red>开始时间</font></td>
			<td><font color=red>结束时间</font></td>
			<td><font color=red>金额</font></td>
			<td><font color=red>操作</font></td>
		</tr>
		<jsp:useBean id="db" class="bean.DBBean" scope="page" />
		<%
			String s = "select * from Buyinfo;";
			ResultSet rs = db.executeQuery(s);
			while (rs.next()) {
				String owneridparkid = rs.getString(1);
				out.println("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6)
						+ "</td><td>" + rs.getString(7) + "</td><td>" + rs.getString(8)+ "</td><td>" + rs.getString(9)+ "</td><td>" + rs.getString(10)+ "</td><td>" + rs.getString(11)
						+ "</td><td><a href='DelParkBuyInfo.jsp?owneridparkid=" + owneridparkid
						+ "'>删除</a>&nbsp;<a href='EditParkBuyInfo.jsp?owneridparkid=" + owneridparkid
						+ "'>修改</a></td></tr>");
			}
			rs.close();
			db.close();
		%>
	</table>
</body>
</html>