<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>�����</title>
    <style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
    </style>
</head>
  
  <body  background="3.jpg" >
  <center>
  <br/><br/> 
	<div align="center" >
    <form action="loan.loancreate" method="post">
	<p style="font-size:19px">������š�<input  type="text" name="v1" value="<%=session.getAttribute("loankey") %>"/></p>
	<p style="font-size:19px">����ͬ�š�<input  type="text" name="v2" /></p>
	<p style="font-size:19px">���ͻ��š�<input  type="text" name="v3" /></p>
	<p style="font-size:19px">�ͻ�������<input  type="text" name="v4" /></p>
 	<p style="font-size:19px">�����<input  type="text" name="v5" /></p>
	<input type="submit" value="ȷ��">
	</form>
	</div>
		<h4>${loancreate_info}</h4>
  </center>
  </body>
</html>