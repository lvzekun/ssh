<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript">
  function validate()
  {
		  var id = document.getElementById("id").value;
		 
		  var name = document.getElementById("couresName").value;
		  if(name.length==0)
			  {
				  document.getElementById("error").innerHTML="用户名不能为空";
				  return false;
			  }
		  
	  return true;
  }
  </script>
<link href="css/admin.css" rel="stylesheet" type="text/css"/>
<link href="css/theme.css" rel="stylesheet" type="text/css"/>
<title>修改用户</title>
<%int i =0; %>
</head>
<body>
<div class="body-box">
    <form action="sup.action" method="post">
       <table width="50%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
			<tr>
          <td width="10%" class="pn-flabel pn-flabel-h">课程编号：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="id" id="name" value="${user.id}">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">课程名称：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="couresName" id="couresName" value="${user.couresName} ">
          </td>
          </tr>
         <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">课程性质：</td>
          <td width="40%" class="pn-fcontent">
            <SELECT NAME="cnature" id="cnature">  
            <OPTION VALUE="0">请选择课程性质 </OPTION>  
            <OPTION VALUE="选修课">选修课 </OPTION>  
            <OPTION VALUE="必修课">必修课 </OPTION>  
            <OPTION VALUE="限选课">限选课 </OPTION>  
           
        </SELECT>  
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">学分：</td>
          <td width="40%" class="pn-fcontent">
             <select name="credit">
             <%   while(i++<4)
            	 {%>
               <option value="<%=i %>"><%=i %></option>
               <%} %>
             </select>
          </td>
          </tr>
          
           <tr>
              <td width="40%" class="pn-fcontent" colspan="2">
                    <div id="error" style="color:red"></div>
             </td>
          </tr>
         	<tr>
					<td colspan="2" class="pn-fbutton" width="50%">
						<input type="submit" value="修改" class="submit"  onclick="return validate();"  /> &nbsp; 
						<input type="reset" value="重置" class="reset" class="reset"/>
					</td>
			</tr>
       
       </table>
    
    </form>
    </div>
</body>
</html>