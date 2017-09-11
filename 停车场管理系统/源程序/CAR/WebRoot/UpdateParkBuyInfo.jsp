<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.sql.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改编辑后的停车场管理员信息</title>
</head>
<body>
	<jsp:useBean id="db" class="bean.DBBean" scope="page" />
	<%
		request.setCharacterEncoding("UTF-8");
	String str_owneridparkid = request.getParameter("owneridparkid");

	

	int owneridparkid = Integer.parseInt(str_owneridparkid);

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
	String sql = "update Buyinfo set ownername=" + "'"+ownername +"'"
			+ ",ownerphone=" + ownerphone + ",starttime=" + "'"+starttime+"'" + ",endtime=" +"'"+ endtime+"'" + ",jine=" + jine + ",parkid=" + "'" + parkid + "'"
			+ ",ownersex=" + "'" + ownersex + "'" 
			+ ",owneridnumber=" + owneridnumber + ",owneraddress=" + "'"
			+ owneraddress + "'" + ",carid=" + "'" + carid + "'"
			+ " where owneridparkid=" + owneridparkid;
		System.out.println("sql=" + sql);
		int i = db.executeUpdate(sql);
		if (i == 1) {
			out.println("<script language='javaScript'> alert('修改成功，点击确定后自动跳到主页。');</script>");
			response.setHeader("refresh", "1;url=buy_index.jsp");
		}
		db.close();
	%>
</body>
</html>