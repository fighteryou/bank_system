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
		if(!(/^\w{3,15}$/.test(f.userpass.value))){
			alert("�û����������3~15λ��") ;
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

	<body background="8.jpg">
		<center>
	<br/><br/><br/><br/>
	<div align="center" width="100px" height="50px" >
	<form action="changepassword.change" method="post" onSubmit="return validate(this)">
	<p style="font-size:19px">�ˡ�����<input id="userid" type="text" name="userid" /></p>
	<p style="font-size:19px">ԭʼ����<input id="oldpassword" type="password" name="olduserpass" /></p>
	<p style="font-size:19px">�µ�����<input id="password" type="password" name="userpass" /></p>
    <p style="font-size:19px">ȷ������<input id="repassword" type="password" name="reuserpass" /></p>
	<input type="submit" value="�޸�����">
	</form>
</div>
<h4>${changepassword_info}</h4>
		</center>
	</body>
</html>
