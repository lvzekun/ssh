<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddClass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
    添加班级 <br>
     <div class="body-box" align="center">
    <form name="Add" action="Add.action" method="post">
      <table border="0">
        <tr>
         <td>编号:</td>
          <td><input type="text" name="id" id="id"></td>
        </tr>
        <tr>
          <td>班级:</td>
          <td><input type="text" name="className" id="className"></td>
          </tr>
        <tr>
          <td colspan="2" align="center">
          <input type="submit" value=" 确定 " >
          </td>
          
        </tr>
      </table>
    </form>
    
    </div>
    </center>
  </body>
</html>
