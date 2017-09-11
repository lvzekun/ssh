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
		 
		  var name = document.getElementById("userName").value;
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
    <form action="update2.action" method="post">
       <table width="50%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
			<tr>
          <td width="10%" class="pn-flabel pn-flabel-h">编号：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="numcar" id="numcar" value="${user.numcar}">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">记录员：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="player" id="player" value="${user.player}">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">出生日期：</td>
          <td width="40%" class="pn-fcontent">
            <input type="text" name="time1" value=" ${user.time1} "
                                readonly="readonly"
                                class="Wdate"
                                onFocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
          </td>
          </tr>
           <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">出生日期：</td>
          <td width="40%" class="pn-fcontent">
            <input type="text" name="time2" value="${user.time2}  "
                                readonly="readonly"
                                class="Wdate"
                                onFocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
          </td>
          </tr>
        
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">停车号：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="carid" id="carid" value="${user.carid}">
          </td>
          </tr>
         <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">停车未：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="parkid" id="parkid" value="${user.parkid}" >
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