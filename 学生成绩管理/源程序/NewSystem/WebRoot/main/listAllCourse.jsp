<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
<LINK href="css/theme.css" type="text/css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
<center>
<s:if test="#request.allCouresList.size>0">
                                    课程信息管理
<table border="1" class="tab_css_1" width="80%">
 <tr>
   <th>编号</th>
   <th>课程名称</th>
   <th>课程性质</th>
   <th>课程学分</th>
   <th colspan="2">操作</th>
 </tr>
  <s:iterator value="#request.allCouresList" id="u">
 <tr class="tr_css" align="center">
   <td><s:property value="#u.id"/></td>    
   <td><s:property value="#u.couresName"/></td>  
   <td><s:property value="#u.cnature"/></td> 
   <td><s:property value="#u.credit"/>（分） </td>
  
	<td>
	<s:a href="supdate.action?id=%{#u.id}">修改</s:a>
	</td>
	<td>
	<s:a href="sdelete.action?id=%{#u.id}" onclick="return confirm('确定删除该课程吗？');">删除</s:a>
	</td>
 </tr>
 </s:iterator>
</table>
<s:if test="#request.pb!=null">

<!--  <page:page pager="${pb}"/>-->
</s:if>
</s:if>
<s:else>
  <font size="4" color="red">没有查询到任何记录</font>
</s:else>
</center>

</body>
</html>