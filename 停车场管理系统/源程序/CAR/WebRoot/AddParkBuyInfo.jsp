<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.sql.*" errorPage="error.jsp"%>
<html>
<head>
<title>添加停车场管理员信息</title>
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
</head>
<body>
	添加购买车位信息
	<form method="post">
		<table>
			<caption>添加购买车位信息</caption>
		
			<tr>
				<th width="30%">买家姓名：</th>
				<td width="70%"><input name="ownername" type="text"></td>
			</tr>
			<tr>
				<th>买家电话：</th>
				<td><input name="ownerphone" type="text"></td>
			</tr>
			<tr>
				<th>买家性别：</th>
				<td><input name="ownersex" type="text"></td>
			</tr>
			<tr>
				<th>买家身份证号：</th>
				<td><input name="owneridnumber" type="text"></td>
			</tr>
			<tr>
				<th>单元号：</th>
				<td><input name="owneraddress" type="text"></td>
			</tr>
			<tr>
				<th>买家车牌号：</th>
				<td><input name="carid" type="text"></td>
			</tr>
			<tr>
				<th>车位号：</th>
				<td><input name="parkid" type="text"></td>
			</tr>
			<tr>
				<th>开始时间：</th>
				<td><input name="starttime" type="text"></td>
			</tr>
			<tr>
				<th>结束时间：</th>
				<td><input name="endtime" type="text"></td>
			</tr>
			<tr>
				<th>金额：</th>
				<td><input name="jine" type="text"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" name="submit" value="添加">
					<input type="reset" value="重置"></th>
			</tr>
		</table>
	</form>
	<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	<%
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("submit");

		if (submit != null && !submit.equals("")) {
			String owneridparkid = request.getParameter("owneridparkid");
			String ownername = request.getParameter("ownername");
			String ownerphone = request.getParameter("ownerphone");

			
		

			String ownersex = request.getParameter("ownersex");
			String owneridnumber = request.getParameter("owneridnumber");
			String owneraddress = request.getParameter("owneraddress");
			String carid = request.getParameter("carid");
			String parkid = request.getParameter("parkid");
			String starttime = request.getParameter("starttime");

			String endtime = request.getParameter("endtime");

			String jine = request.getParameter("jine");


			//先判断表中是否有相同书号的图书，如果有，则添加失败

			String sql = "insert into Buyinfo values('" + ownername + "',"
					+ ownerphone + ",'" + ownersex + "','" + owneridnumber + "','" + owneraddress + "','" + carid + "','" + parkid + "','" + starttime + "','" + endtime + "','" + jine + "')";
			int i = db.executeUpdate(sql);
			if (i == 1) {
				out.println("<script language='javaScript'> alert('添加成功,点击确定跳转到主页!');</script>");
				response.setHeader("refresh", "1;url=buy_index.jsp");
			} else {
				out.println("<script language='javaScript'> alert('添加失败，点击确定返回添加页面！');</script>");
				response.setHeader("refresh", "1;url=AddParkBuyInfo.jsp");
			}
			db.close();
		}
	%>
</body>
</html>
