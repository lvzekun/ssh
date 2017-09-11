<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.sql.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改购买车位信息</title>
</head>
<style type="text/css">
table {
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 400px;
}

th, td {
	border: solid #333 1px;
	height: 20px;
}

div {
	text-align: center;
}
</style>
<body>
	<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	<%
		request.setCharacterEncoding("utf-8");

String str_owneridparkid = request.getParameter("owneridparkid");

	

	int owneridparkid = Integer.parseInt(str_owneridparkid);
		System.out.println("owneridparkid="+owneridparkid);
		String sql = "select * from Buyinfo where owneridparkid=" + owneridparkid;
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);
		rs.next();
	%>
	<form action="UpdateParkBuyInfo.jsp" method="post">
		<table>
			<caption>修改停车场管理员信息</caption>
			<tr>
				<th>编号：</th>
				<td><input name="owneridparkid" type="text" readonly="readonly"
					value="<%=rs.getInt(1)%>">不能修改</td>
			</tr>
			<tr>
				<th width="30%">买家姓名：</th>
				<td width="70%"><input name="ownername" type="text" value="<%=rs.getString(2)%>"></td>
			</tr>
			<tr>
				<th>买家电话：</th>
				<td><input name="ownerphone" type="text" value="<%=rs.getString(3)%>"></td>
			</tr>
			<tr>
				<th>买家性别：</th>
				<td><input name="ownersex" type="text" value="<%=rs.getString(4)%>"></td>
			</tr>
			<tr>
				<th>买家编号：</th>
				<td><input name="owneridnumber" type="text"  value="<%=rs.getString(5)%>"></td>
			</tr>
			<tr>
				<th>单元号：</th>
				<td><input name="owneraddress" type="text"  value="<%=rs.getString(6)%>"></td>
			</tr>
			<tr>
				<th>买家车牌号：</th>
				<td><input name="carid" type="text"  value="<%=rs.getString(7)%>"></td>
			</tr>
			<tr>
				<th>车位编号：</th>
				<td><input name="parkid" type="text" value="<%=rs.getString(8)%>"></td>
			</tr>
			<tr>
				<th>开始时间：</th>
				<td><input name="starttime" type="text" value="<%=rs.getString(9)%>"></td>
			</tr>
			<tr>
				<th>结束时间：</th>
				<td><input name="endtime" type="text" value="<%=rs.getString(10)%>"></td>
			</tr>
			<tr>
				<th>金额：</th>
				<td><input name="jine" type="text" value="<%=rs.getString(11)%>"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="修改"> <input
					type="reset" value="重置"></th>
			</tr>
		</table>

	</form>
	<%
		rs.close();
		db.close();
	%>
</body>
</html>