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
		if(!(/^\w{3,15}$/.test(f.userid.value))){
			alert("�û�ID������3~15λ��") ;
			f.userid.focus() ;
			return false ;
		}
		if(f.userpass.value!=f.reuserpass.value){
			alert("���������벻��ȣ���ȷ�������룡") ;
			f.userpass.focus() ;
			return false ;
		}
		
	}
</script>


	<body background="7.jpg">
		<center>
<br/><br/>
<div align="center" width="100px" height="50px" >
	<form action="register.reg" method="post" onSubmit="return validate(this)">
	<p style="font-size:19px">�ˡ����� <input id="userid" type="text" name="userid" /></p>
	<p style="font-size:19px">�ܡ����� <input id="password" type="password" name="userpass" /></p>
    <p style="font-size:19px">ȷ������ <input id="repassword" type="password" name="reuserpass" /></p>
 	<p style="font-size:19px">��   ɫ ID <input id="roleid" type="text" name="roleid" /></p>
 	<p style="font-size:19px">�ǡ����� <input id="username" type="text" name="username" /></p>
 	<p style="font-size:19px">�ԡ����� <input id="usersex" type="text" name="usersex" /></p>
 	<p style="font-size:19px">�ꡡ���� <input id="userage" type="text" name="userage" /></p>
 	<p style="font-size:19px">���֤�� <input id="useridentity" type="text" name="useridentity" /></p>
 	<p style="font-size:19px">��ϵ�绰 <input id="userphone" type="text" name="userphone" /></p>
	<input type="submit" value="ע��">
	</form>
</div>

	<h4>${register_info}</h4>
	</center>
	
	</body>
</html>
