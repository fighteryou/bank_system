<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>�˻�����</title>
    <style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
    </style>
</head>
  
  <body >
  <center>
  <br/><br/> 
	<div align="center" >
    <form action="acctcreate.acctcreate" method="post">
	<p style="font-size:19px">���˻��š�<input  type="text" name="internalkey"/></p>
	<p style="font-size:19px">�˻���<input  type="text" name="ledgerbal" /></p>  
    <p style="font-size:19px">���ͻ��š�<input  type="text" name="clientno" /></p>
	<input type="submit" value="ȷ��">
	</form>
	</div>
		<h4>${acctcreate_info}</h4>
  </center>
  </body>
</html>