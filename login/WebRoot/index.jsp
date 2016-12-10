<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
  </head>
  
  <body>
    <ul >
      <li>用户名：
          <input id="Text1" type="text" class="txt" />  
      </li>
      <li>密码：&nbsp;&nbsp;&nbsp;
         <input id="Text2" type="password" class="txt" />  
      </li>
	</ul>
	<span>
    <button id="regester" onclick="javascript:regester()">
  	  注册</button>
	</span>
     <span>
    <button id="login" onclick="javascript:login()">
  	  登陆</button>
	</span>
<script type="text/javascript">
$(function(){
	 $("#Text1").val("");
	 $("#Text1").val("");
});
function login(){
	var username=$("#Text1").val();
	var pwd=$("#Text2").val();
	$.post("user_login.action",{userName:username,pwd:pwd},function(data){
		if(data=="1")
		{
		alert("登陆成功！");
		}
	} );
}

function regester(){
	alert("注册成功！");
}
</script>
  </body>
</html>

