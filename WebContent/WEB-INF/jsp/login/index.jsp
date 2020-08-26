<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.framework.util.ManageConstants"%>
<%
String basePath = (String)request.getServletContext().getAttribute(ManageConstants.BASE_PATH);
String staticPath = (String)request.getServletContext().getAttribute(ManageConstants.STATIC_PATH);
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta name="renderer" content="webkit"> 
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="bin/image/favicon.ico" />
<title>登录</title>

<link rel="stylesheet" type="text/css" href="<%=staticPath%>bin/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=staticPath%>bin/css/index.css" />

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
  <script src="bin/js/html5/html5.js"></script>
  <script src="bin/js/html5/html5shiv.min.js"></script>
  <script src="bin/js/html5/respond.min.js"></script>
<![endif]-->

<script type="text/javascript" src="<%=staticPath%>bin/js/jquery-1.9.1.js"></script>
<script type="text/javascript" >
$(document).ready(function(){
	var w = window.screen.width;
	var h = window.screen.height;
		
	window.moveTo(0,0);
	window.resizeTo(w,h);
	$("#username").focus();
		$("#username").on("blur",function() {
			if($("#username").val()==""){
				$("#spname").show();
			}
		});	
		
		$("#password").on("blur",function() {
			if($("#password").val()==""){
				$("#sppassword").show();
			}
		});	
		document.onkeydown = index_onkeydown;
});
	
function index_onkeydown(e){
	e = e || event;
	var obj = e.srcElement ? e.srcElement : e.target;
	if(e.keyCode==13){
		if(obj.id=="username"){
			$("#password").focus();
		}else if(obj.id=="password"){
			login_click();
		}
	}
	return true;
}
function login_click(){
	//判断非空
	if($('#username').val() == "" ){
		alert("用户名不能为空");
		$('#username').focus();
		return false;
	}

	//判断非空
	if($('#password').val()==""){
		$('#password').focus();
		return false;
	}

	//通过用户代码取得名称
	$.ajax({
		async:false,
		type: "post",
		dataType: "json",
		url: "checkUser",
		data: {
			USERID	  : $('#username').val(),
			PASSWORD	: $('#password').val()
		},
		success: function(response){
			if(response=="OK"){
				location.href="";
			}else if(response=="NONE"){
				alert("用户不存在！");
				return;
			}else if(response=="PASSERR"){
				alert("用户名或密码错误！");
				return;
			}else if(response=="NOPOWER"){
				alert("当前用户无功能权限，请与管理员联系！");
				return;
			}else{
				alert("当前用户登录异常，请与管理员联系！");
				return;
			}

			

		}
	});
}
</script>
</head>
<body>
<div class="box">
	<div class="container_new">
		<image src="<%=staticPath%>bin/image/bg_New.png" class="container_new_pic"/>
		<div class="login-content ">
			<div class="form">
				<form action="#" method="post" class="form_div">
					<div class="form-group">
						<div class="form-group_divNew">
							<image src="<%=staticPath%>bin/image/icon_username.png" class="icon_username"/>
							<input type="text" id="username" name="username" placeholder="用户名" style="width:80%;">
						</div>
					</div>
					<div class="form-group">
						<div class="form-group_divNew">
							<image src="<%=staticPath%>bin/image/icon_password.png" class="icon_username"/>
							<input type="password" id="password" name="password" placeholder="密码" style="width:80%;">

						</div>
					</div>
					<div class="form-group form-actions">
						<div style="text-align: center;" >
							<button type="button" class="newButton" class="form-control" onclick="login_click()" >
								登录
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>

</div>
</body>
</html>