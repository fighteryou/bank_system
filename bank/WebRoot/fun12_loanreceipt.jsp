<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="java.text.*"%> 
<% String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //��ȡϵͳʱ�� 
%> 
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>�������</title>
    <style type="text/css">
    </style>
</head>
  <body  background="3.jpg" >
  <center>
  <br/><br/> 
	<div align="center" >
    <form action="loan.loanreceipt" method="post">
	<p style="font-size:19px">��&nbsp; ��&nbsp; ��<input id="a1" type="text" name="loankey"/></p>
	<p style="font-size:19px">����ź�<input id="a2" type="text" name="ddno" /></p>
	<p style="font-size:19px">&nbsp; Ӧ������<input id="a3" type="text" name="prioutstanding" /></p>
	<p style="font-size:19px">&nbsp; Ӧ����Ϣ<input id="a4" type="text" name="intoutstanding" /></p>  
 	<p style="font-size:19px">&nbsp; ���ս��<input id="a5" type="text" name="receiptamt" /></p>
	<input type="submit" value="¼��"onclick="re();">
	</form>
	</div>
		<h4>${loanreceipt_info}</h4>
  </center>
  </body>
</html>