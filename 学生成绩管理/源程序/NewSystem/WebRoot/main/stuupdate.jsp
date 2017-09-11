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
		  var psw = document.getElementById("password").value;
		  var name = document.getElementById("name").value;
		  var id = document.getElementById("classid").value;
		  var telephone=document.getElementById("telephone").value;
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
	     if(name.length==0)
			  {
				  document.getElementById("error").innerHTML="姓名不能为空";
				  return false;
			  }
			  if(telephone.length==0)
			  {
			     document.getElementById("error").innerHTML="手机号不能为空";
				  return false;
			  
			  }
	  return true;
  }
  </script>
<link href="css/admin.css" rel="stylesheet" type="text/css"/>
<link href="css/theme.css" rel="stylesheet" type="text/css"/>
<title>修改学生信息</title>
<%int i =0; %>
</head>
<body>
<br>
<br>
<br>
<div class="body-box" align="center">
    <form action="stu.action" method="post">
       <table width="50%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
			<tr>
          <td width="10%" class="pn-flabel pn-flabel-h">学号：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="number" id="number" value="${user.number}">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">姓名：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="name" id="name"  value="${user.name}">
          </td>
          </tr>
           <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">性别：</td>
          <td width="40%" class="pn-fcontent">
               <input type="radio" name="gender" value="男"checked="checked">男(male)
               <input type="radio" name="gender" value="女">女(female)
          </td>
          </tr>
          
           <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">出生日期：</td>
          <td width="40%" class="pn-fcontent">
            <input type="text" name="brithday" value="  "
                                readonly="readonly"
                                class="Wdate"
                                onFocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">密码：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="password" id="password"  value="${user.password}"></td>
         
          </tr>
          
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">手机号：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="telephone" id="telephone"  value="${user.telephone}">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">家庭住址：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="addresshome" id="addresshome"  value="${user.addresshome}">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">班级编号：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="classid" id="classid"  value="${user.classid}">
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