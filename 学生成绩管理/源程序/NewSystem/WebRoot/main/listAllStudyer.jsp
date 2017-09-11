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
<s:if test="#request.allStudyerList.size>0">
                                      学生信息管理
<table border="1" class="tab_css_1" width="80%">
 <tr>
   <th>学号</th>
   <th>姓名</th>
   <th>性别</th>
   <th>出生日期</th>
   <th>密码</th>
   <th>手机</th>
   <th>住址</th>
   
   <th>班级编号</th>
   <th colspan="2">操作</th>
 </tr>
  <s:iterator value="#request.allStudyerList" id="u">
 <tr class="tr_css" align="center">
   <td><s:property value="#u.number"/></td>    
   <td><s:property value="#u.name"/></td>  
    <td><s:property value="#u.gender"/></td>   
     <td><s:property value="#u.brithday"/></td>   
     <td><s:property value="#u.password"/></td>   
       <td><s:property value="#u.telephone"/></td>   
        <td><s:property value="#u.addresshome"/></td>  
         
         <td><s:property value="#u.classid"/></td>      
  
	<td>
	<s:a href="stuupdate.action?number=%{#u.number}">修改</s:a>
	</td>
	<td>
	<s:a href="deletestu.action?number=%{#u.number}" onclick="return confirm('确定删除该用户吗？');">删除</s:a>
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