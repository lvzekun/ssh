<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="${pageContext.request.contextPath}/css/admin.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
   function closeCurrentWindow()
   {
       if (confirm('ȷ��Ҫ�˳���'))
        {
	        window.top.location="Login.jsp"
		    return true; 
        }
       else 
            return false;
   }

</script>
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" 
background="${pageContext.request.contextPath}/images/header_bg.jpg" border=0>
  <TR height=56>
    <TD width=260><IMG height=56 src="${pageContext.request.contextPath}/images/header_left.jpg" 
    width=260></TD>
    <TD style="FONT-WEIGHT: bold; COLOR: #fff; PADDING-TOP: 20px" 
      align=middle>��ǰ�û���<font color="red">${sessionScope.user.uname}</font> &nbsp;&nbsp; 
      <A style="COLOR: #fff"      onclick="closeCurrentWindow();" 
      href="javascript:void(0)" target="main">�˳�ϵͳ</A>
    </TD>
    <TD align=right width=268><IMG height=56 
      src="${pageContext.request.contextPath}/images/header_right.jpg" width=268></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TR bgColor=#1c5db6 height=4>
    <TD></TD></TR></TABLE></BODY></HTML>
    