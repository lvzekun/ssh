<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="s" uri="/struts-tags"%>

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
<s:if test="#request.allUserList.size>0">
                                      班级信息管理
<table border="1" class="tab_css_1" width="80%">
 <tr>
   <th>编号</th>
   <th>班级名称</th>
   
   <th colspan="2">操作</th>
 </tr>
  <s:iterator value="#request.allUserList" id="u">
  <tr class="tr_css" align="center">
   <td><s:property value="#u.id"/></td>    
   <td><s:property value="#u.className"/></td>    
  
	<td>
	<s:a href="preupdate.action?id=%{#u.id}">修改</s:a>
	</td>
	<td>
	<s:a href="delete.action?id=%{#u.id}" onclick="return confirm('确定删除该用户吗？');">删除</s:a>
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