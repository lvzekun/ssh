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
		  var numcar = document.getElementById("numcar").value;
		  var time1 = document.getElementById("time1").value;
		  var time2 = document.getElementById("time2").value;
		  var t3 = document.getElementById("player").value;
		  if(time1.length==0)
			  {
				  document.getElementById("error").innerHTML="时间不能为空";
				  return false;
			  }
			   if(t3.length==0)
			  {
				  document.getElementById("error").innerHTML="记录员不能为空";
				  return false;
			  }
		  if(numcar.length==0)
			  {
				  document.getElementById("error").innerHTML="车牌号不能为空";
				  return false;
			  }
			  if(time1==time2)
			  {
				  document.getElementById("error").innerHTML="近出入时间一致，请重新输入";
				  return false;
			  }
	  return true;
  }
  </script>
<link href="css/admin.css" rel="stylesheet" type="text/css"/>
<link href="css/theme.css" rel="stylesheet" type="text/css"/>
<title>汽车添加</title>
<%int i =0; %>
</head>

<% Object username=session.getAttribute("username");%>

<body>
<br>
<br>
<br>
<div class="body-box" align="center">
    <form action="incar.action" method="post">
       <table width="50%" class="pn-ftable" cellpadding="2" cellspacing="1" border="0">
			<tr>
          <td width="10%" class="pn-flabel pn-flabel-h">车牌号：</td>
          <td width="40%" class="pn-fcontent">
             <input type="text" name="numcar" id="numcar">
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">记录员：</td>
          <td width="40%" class="pn-fcontent">
              <input type="text" name="player" id="player" values="player">
          </td>
          </tr>
          
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">进入时间：</td>
          <td width="40%" class="pn-fcontent">
            <input type="text" name="time1" value=""
                                readonly="readonly"
                                class="Wdate"
                                onFocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
          </td>
          </tr>
          
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">离开时间：</td>
          <td width="40%" class="pn-fcontent">
            <input type="text" name="time2" value=""
                                readonly="readonly"
                                class="Wdate"
                                onFocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
          </td>
          </tr>
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">停车场：</td>
          <td width="40%" class="pn-fcontent">
              <input type="text" name="parkid" id="parkid" >
          </td>
          </tr>
          
          <tr>
          <td width="10%" class="pn-flabel pn-flabel-h">停车位：</td>
          <td width="40%" class="pn-fcontent">
             <select name="carid">
             <%   while(i++<300)
            	 {%>
               <option value="<%=i %>"><%=i %></option>
               <%} %>
             </select>
          </td>
          </tr>
          <tr>
         <tr>
         
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