<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head><title>��½</title></head>
<body background="5.jpg"   >
<% 
	request.setCharacterEncoding("GBK");
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script language="javascript">
	function validate(f){
		if(!(/^\w{3,15}$/.test(f.userid.value))){
			alert("�û����������3~15λ��") ;
			f.userid.focus() ;
			return false ;
		}
		if(!(/^\w{3,15}$/.test(f.userpass.value))){
			alert("�û�ID������3~15λ��") ;
			f.userid.focus() ;
			return false ;
		}
	}
</script>


</br></br></br></br></br></br> 


<div align="center" width="100px" height="50px">
<form action="login.do" method="post" onSubmit="return validate(this)">
 <p style="font-size:19px">�˺� <input id="userid" type="text" name="userid" /></p>
  <p style="font-size:19px">���� <input id="password" type="password" name="userpass" /></p>
	<input type="submit" value="��½">
	<input type="reset" value="����">
</form>
<h4>${info}</h4>

</div>


</body>
</html>