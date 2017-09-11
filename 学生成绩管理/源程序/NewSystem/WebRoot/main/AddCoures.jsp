<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript">
  function validate()
  {
		  var psw = document.getElementById("psw").value;
		 // var repsw = document.getElementById("repsw").value;
		  var id = document.getElementById("id").value;
		  if(id.length==0)
			  {
				  document.getElementById("error").innerHTML="编号不能为空";
				  return false;
			  }
		  if(psw.length==0)
			  {
				  document.getElementById("error").innerHTML="课程名不能为空";
				  return false;
			  }
			 /* if(psw!=repsw)
			  {
				  document.getElementById("error").innerHTML="密码和重复密码不一致，请重新输入";
				  return false;
			  }*/
	  return true;
  }
  </script>
<link href="css/admin.css" rel="stylesheet" type="text/css"/>
<link href="css/theme.css" rel="stylesheet" type="text/css"/>
<title>添加课程</title>
<%int i =0; %>
</head>
<body>
<br>
<br>
<br>
<div class="body-box" align="center">
    <form action="addCoures.action" method="post">
       <table width="50%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
			<tr>
          <td width="10%" class="pn-flabel pn-flabel-h">编号：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="id" id="id">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">课程名称：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="couresName" id="psw">
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
						<input type="submit" value="提交" class="submit"  onclick="return validate();"  /> &nbsp; 
						<input type="reset" value="重置" class="reset" class="reset"/>
					</td>
				</tr>
       
       </table>
    
    </form>
    </div>
</body>
</html>