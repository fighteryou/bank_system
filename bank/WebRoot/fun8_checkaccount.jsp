<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��ѯ�˻�</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="6.jpg">
      <center>
      <br/><br/>
	<div align="center" >
    <form action="loan.checkaccount" method="post">
 	<p style="font-size:19px">���˺š�<input  type="text" name="v1" /></p>
 	<p style="font-size:19px">��������<input  id="a1" type="text" name="v2" value="<%=session.getAttribute("a1") %>"/></p>
 	<p style="font-size:19px">�ͻ���<input  id="a1" type="text" name="v3" value="<%=session.getAttribute("a2") %>"/></p>
 	<p style="font-size:19px">�˻����<input  id="a4" type="text" name="v4" value="<%=session.getAttribute("a3") %>"/></p>		
 	<input type="submit" value="��ѯ">
	</form>				

	</div>
  </center>
  </body>
</html>
