<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	</head>
	
	
<script language="javascript">
	function validate(f){
		
		
	}
</script>

	<body>
		<center>
<br/><br/>
<div align="center" >
	
	<form action="settlepay.spay" method="post" onSubmit="return validate(this)">
	<p style="font-size:19px">��&nbsp;��&nbsp;��<input id="city" type="text" name="client" /></p>  	
 	<p style="font-size:19px">�����˺�<input id="address" type="text" name="acct" /></p>
 	<p style="font-size:19px">������<input id="country" type="text" name="payamt" /></p>
 	<p style="font-size:19px">�ͻ��˺�<input id="job" type="text" name="baseacctno" /></p>
	<input type="submit" value="�ύ">
	</form>
</div>
	<h4>${settlepay_info}</h4>
	</center>
	
	</body>
</html>