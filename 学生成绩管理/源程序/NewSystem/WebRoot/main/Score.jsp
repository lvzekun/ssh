<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.Studyer" %>
<%@ page import="com.bean.Coures" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

    List<Studyer> allStudyerList = (List<Studyer>)request.getAttribute("allStudyerList");
    //获取所有的term信息
    List<Coures> allCouresList = (List<Coures>)request.getAttribute("allCouresList");
    String username=(String)session.getAttribute("username");
   
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript">
  function validate()
  {
		  var Score = document.getElementById("Score").value;
		 
		  if(Score.length==0)
			  {
				  document.getElementById("error").innerHTML="成绩不能为空";
				  return false;
			}
	  return true;
  }
  </script>
<link href="css/admin.css" rel="stylesheet" type="text/css"/>
<link href="css/theme.css" rel="stylesheet" type="text/css"/>
<title>添加学生信息</title>
<%int i =0; %>
</head>
<body>
<br>
<br>
<br>
<div class="body-box" align="center">
    <form action="AddScore.action" method="post">
       <table width="50%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
			<tr>
          <td width="10%" class="pn-flabel pn-flabel-h">学生姓名：</td>
          <td width="40%" class="pn-fcontent">
          <select name="number">
          <%
            for(Studyer number:allStudyerList) {
           %>
              <option value='<%=number.getNumber() %>'><%=number.getNumber() %></option>
          <%
             }
             %>
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">课程编号：</td>
          <td width="40%" class="pn-fcontent">
            <select name="id">
          <%
            for(Coures coures:allCouresList) {
           %>
              <option value='<%=coures.getId() %>'><%=coures.getId() %></option>
          <%
             }
           %>
          </td>
          </tr>
           <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">成绩：</td>
          <td width="40%" class="pn-fcontent">
               <input type="text" name="credit" id="Score">(分)
              
          </td>
          </tr>
         
         
          <tr>
            <td width="40%" class="pn-fcontent" colspan="2">
             <div id="error" style="color:red"></div>
          </td>
          </tr>
				<tr>
					<td colspan="2" class="pn-fbutton" width="50%">
						<input type="submit" value="提交" class="submit"  onclick="return validate();"  /> &nbsp; 
						<input type="reset" value="重置" class="reset" class="reset"/>
					</td>
				</tr>
       
       </table>
    
    </form>
    </div>
</body>
</html>