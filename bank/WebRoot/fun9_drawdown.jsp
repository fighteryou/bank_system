<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>�����</title>
    <style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
    </style>
</head>
  
  <body  background="12.jpg" >
  <center>
  <br/><br/> 
	<div align="center" >
    <form action="drawdown.drawdown" method="post">
    <p style="font-size:19px">�����<input  type="text" name="v1" /></p>
	<p style="font-size:19px">���ź�<input  type="text" name="v2"/></p>
	<p style="font-size:19px">������<input  type="text" name="v3" /></p>
 	<p style="font-size:19px">���Ž�� <input  type="text" name="v4" /></p>
	<p style="font-size:19px">�ͻ�����Ĭ���˺�<input  type="text" name="v5" /></p>  
 	
	<input type="submit" value="ȷ��">&nbsp;
	</form>
	</div>
		<h4>${drawdown_info}</h4>
  </center>
  </body>
</html>