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
<s:if test="#request.allUserList.size>0">
停车信息管理
<table border="1" class="tab_css_1" width="80%">
 <tr>
   <th>汽车车牌号</th>
   <th>记录员</th>
   <th>停车时间</th>
   <th>离开时间</th>
   <th>车位号</th>
   <th>停车场</th>
  
 </tr>
  <s:iterator value="#request.allUserList" id="u">
 <tr class="tr_css" align="center">
   <td><s:property value="#u.numcar"/></td>    
   <td><s:property value="#u.player"/></td>    
   <td><s:property value="#u.time1"/></td>    
   <td><s:property value="#u.time2"/></td> 
   <td><s:property value="#u.carid"/>号</td>  
   <td><s:property value="#u.parkid"/>(场)</td>   
	
	
 </tr>
 </s:iterator>
</table>
<s:if test="#request.pb!=null">


</s:if>
</s:if>
<s:else>
  <font size="4" color="red">没有查询到任何记录</font>
</s:else>
</center>

</body>
</html>