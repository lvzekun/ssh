<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<%@ page import="com.bean.Studyer" %>
<%@ page import="com.bean.Coures" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //获取所有的student信息
    List<Studyer> allStudyerList = (List<Studyer>)request.getAttribute("allStudyerList");
    //获取所有的term信息
    List<Coures> allCouresList = (List<Coures>)request.getAttribute("allCouresList");
    
%>
<HTML><HEAD><TITLE>添加成绩信息</TITLE> 
<STYLE type=text/css>
BODY {
    	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
.label {font-style.:italic; }
.errorLabel {font-style.:italic;  color:red; }
.errorMessage {font-weight:bold; color:red; }
</STYLE>
 <script src="<%=basePath %>calendar.js"></script>
<script language="javascript">
/*验证表单*/
 function validate()
  {
		  var Score = document.getElementById("credit").value;
		 
		  if(Score.length==0)
			  {
				  document.getElementById("error").innerHTML="成绩不能为空";
				  return false;
			}
	  return true;
  }
 </script>
</HEAD>

<BODY>
<s:fielderror cssStyle="color:red" />
<TABLE align="center" height="100%" cellSpacing=0 cellPadding=0 width="80%" border=0>
  <TBODY>
  <TR>
    <TD align="left" vAlign=top >
    <s:form action="AddScore.action" method="post" id="scoreAddForm" onsubmit="return checkForm();" name="form1">
<table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">

  <tr>
    <td width=30%>学生学号:</td>
    <td width=70%>
      <select name="number">
      <%
        for(Studyer studyer:allStudyerList) {
      %>
          <option value='<%=studyer.getNumber() %>'><%=studyer.getNumber() %></option>
      <%
        }
      %>
    </td>
  </tr>

  <tr>
    <td width=30%>课程编号:</td>
    <td width=70%>
       <select name="couresName">
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
    <td width=30%>成绩得分:</td>
    <td width=70%><input id="credit" name="credit" type="text" size="8" /></td>
  </tr>

  <tr bgcolor='#FFFFFF'>
      <td colspan="4" align="center">
       <input type="submit" value="提交" class="submit"  onclick="return validate();"  /> &nbsp; 
	   <input type="reset" value="重置" class="reset" class="reset"/>
      </td>
    </tr>

</table>
</s:form>
   </TD></TR>
  </TBODY>
</TABLE>
</BODY>
</HTML>
