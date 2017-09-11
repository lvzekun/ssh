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
<s:if test="#request.allScoreList.size>0">
                                    成绩信息管理
<table border="1" class="tab_css_1" width="80%">
 <tr>
   <th>学生学号</th>
   <th>课程编号</th>
   <th>课程成绩</th>
 
   <th colspan="2">操作</th>
 </tr>

  
  <s:iterator value="#request.allScoreList" id="u">
  
 <tr class="tr_css" align="center" <s:if test="#u.credit >= 60"></s:if>
	<s:else>style="color: red"</s:else>>
   <td><s:property value="#u.id.studyer.number"/></td>    
   <td><s:property value="#u.id.coures.id"/></td>  
  
   <td>
        <s:property value="#u.credit"/>
   （分） </td>
  
	<td>
	<s:a href="showpeople.action?number=%{#u.id.studyer.number}">学生个人成绩</s:a>
	</td>
	<td>
	<s:a href="showcoures.action?id=%{#u.id.coures.id}">课程成绩汇总</s:a>
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