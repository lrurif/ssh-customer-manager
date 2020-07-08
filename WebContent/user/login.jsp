<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% String path=request.getContextPath()+"/";%>
<html>
<head>
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<link rel="stylesheet" type="text/css" href="../css/user.css"/>
</head>
<body>
	<div class="login">
		<h1 class="login-title">登录</h1>
		<form class="login-form" method="post" action="<%=path %>user/login">
			<div class="user-name">
				<label class="icon"><i class="iconfont icon-user-login"></i></label>
				<input type="text" placeholder="请输入您的用户名" name="user.user_code">
			</div>
			<div class="user-password">
				<label class="icon"><i class="iconfont icon-password-login"></i></label>
				<input type="password" placeholder="请输入您的密码" name="user.user_password">
			</div>
			<input type="submit" class="login-btn" value="登录">
		</form>
	</div>
	<div class="img"></div>
</body>
<script>
	var loginFail = <%=session.getAttribute("loginFail")%>;
	if(loginFail) {
		alert("用户名或密码错误");
	}
	console.log(!!loginFail)
</script>
</html>
