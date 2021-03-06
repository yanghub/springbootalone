<%@page import="com.burro.common.SessionUtil"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.framework.util.ManageConstants"%>
<%@ page import="com.framework.core.SessionManageEntity" %>
<%
String basePath = (String)request.getServletContext().getAttribute(ManageConstants.BASE_PATH);
String staticPath = (String)request.getServletContext().getAttribute(ManageConstants.STATIC_PATH);
SessionManageEntity user = (SessionManageEntity)SessionUtil.getSession(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
<base href="<%=basePath%>">
<title>第一摄影约拍</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="<%=staticPath%>bin/image/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=staticPath%>bin/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=staticPath%>bin/css/font-awesome.css">
<link rel="stylesheet" type="text/css" href="<%=staticPath%>bin/css/home-main.css">
<!-- alertify提示框 CSS -->
<link href="<%=staticPath%>bin/plugin/alertify/alertify.core.css" rel="stylesheet" id="toggleCSS">
<link href="<%=staticPath%>bin/plugin/alertify/alertify.default.css" rel="stylesheet" id="toggleCSS">
<script type="text/javascript" src="<%=staticPath%>bin/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=staticPath%>bin/js/bootstrap.min.js"></script>
<!-- alertify提示框 JS -->
<script src="<%=staticPath%>bin/plugin/alertify/alertify.js"></script>
<!--[if lt IE 9]>
<script src="<%=staticPath%>bin/js/html5/html5shiv.min.js"></script>
<script src="<%=staticPath%>bin/js/html5/respond.js"></script>
<![endif]-->
<script type="text/javascript" src="<%=staticPath%>bin/js/home-main.js?_=${nowTime}"></script>
<script type="text/javascript" src="<%=staticPath%>bin/js/modal.js?_=${nowTime}"></script>
<script type="text/javascript">
	$(function(){
		var testFlag = "${testFlag}";//是否测试环境（false）
		if(testFlag != "9"){
			$("#testflag").html("第一摄影约拍");
			var testStyle = $('<style type="text/css"></style>');
			testStyle.append('.menu-items .menu-item .menu-one{background:#E9741F;}');
			testStyle.append('.menu-items .menu-item .menu-two{background:#E9741F;}');
			$(document.body).append(testStyle);
			$('.shop-menu').css('background','#E9741F');
			$('#page-head').css('background','#E9741F');
			$('.shop-main > div:first-child').css('background','#E9741F');
			
		}
		$(".accordion-noborder .accordion-body").css("height","100%");
		//弹出框初始化
		alertify.set({
			labels : {
				ok : "确认",
				cancel : "取消"
			},
			delay : 5000,
			buttonReverse : false,
			buttonFocus  : "ok"
		});
		$('.domain-item').hover(function(){
			var subitem = $(this).children('.domain-subitem');
			subitem.stop(true);
			subitem.show();
			subitem.animate({opacity:1},200);
		},function(){
			$(this).children('.domain-subitem').animate({opacity:0},150,function(){
				$(this).hide();
			});
		});
		//计算页面各模块大小
		homeMain.pageResize();
		//加载菜单
		$.getJSON("queryUserMenuList", function (data) {
			homeMain.init(data);
// 			$('#9020000').trigger("click");
		});
		homeMain.tab.addTab('第一摄影约拍','welcome',{isCanClose:false});
	});
	//点退出铵钮时，提示
	function logout(){
		top.alertify.confirm("是否退出系统？", function(e) {
			if (e) {
				$.ajax({
					async:false,
					type: "post",
					dataType: "json",
					url: "logout",
					complete:function(response){
						location.href='<%=basePath%>';
					}
				}); 
				return true;
			}
		});
		return false;
	}
	//超时点登录，不提示
	function timeoutLogin(){
		$.ajax({
			async:false,
			type: "post",
			dataType: "json",
			url: "logout",
			complete:function(response){
				location.href='<%=basePath%>';
			}
		}); 
	}
</script>
</head>
<body>
	<div class="shop-main">
		<div>
			<div class="shop-header" id="testflag">第一摄影约拍</div>
			<div class="shop-domain">
				<div class="domain-item">
					<%=user.getUserName() %>
					<span class="glyphicon glyphicon-log-out"></span>
					<div class="domain-subitem">
						<div onclick="modal.open({title:'修改密码',url:'openPassReset'})" class="subitem-btn">修改密码</div>
						<div onClick="logout()" class="subitem-btn">退&emsp;&emsp;出</div>
					</div>
				</div>
<!--  				<div class="domain-item" onclick="modal.open({title:'导出一览表',url:'exportQueueListController',width:'1000px',height:'600px'})">导出一览表</div> -->
<!-- 				<div class="domain-item" onclick="modal.open({title:'升级公告',url:'openUpgradeInfo',height:400})">升级公告</div> -->
<!-- 				<div class="domain-item" onclick="homeMain.tab.addTab('帮助教程','openHelpInfo')">帮助教程</div> -->
<!-- 				<div class="domain-item" onclick="homeMain.tab.addTab('客服回答','customerServiceQAController/openQA')">客服问答</div> -->
			</div>
		</div>
		<div class="shop-menu">
			<div class="fa fa-bars more-btn"></div>
			<div class="menu-items"></div>
		</div>
		<div class="shop-con">
			<div class="menu-tab">
				<div id="tab-btn-left" class="menu-btn fa fa-angle-double-left"></div>
				<div id="tab-btn-right" class="menu-btn fa fa-angle-double-right"></div>
				<div class="menu-tab-items"><div></div></div>
			</div>
			<div class="shop-iframes"></div>
		</div>
	</div>
</body>

</html>