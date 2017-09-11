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
 



课程成绩水平显示<br>
 
  
 

                       
<table border="1" class="tab_css_1" width="80%">
 <tr>
   <th>课程编号</th>
   <th>最高分</th>
   <th>最低分</th>
   <th>平均分</th>
   
   
   
 </tr>

  
  
  
 <tr class="tr_css" align="center"   >
   <td><s:property value="#request.CouresId"/></td>    
    <td <s:if  test="#request.MaxScore >= 60"></s:if>
	
	             <s:else>style="color: red"</s:else> 
    ><s:property value="#request.MaxScore"/></td>    
    <td <s:if  test="#request.MinScore >= 60"></s:if>
	
	             <s:else>style="color: red"</s:else> > 
	
	 <s:property value="#request.MinScore"/>
	</td>    
   <td <s:if  test="#request.InScore >= 60"></s:if>
	
	             <s:else>style="color: red"</s:else>
   ><s:property value="#request.InScore"/></td>    
	
 </tr>
 
</table>



</center>

</body>
</html>