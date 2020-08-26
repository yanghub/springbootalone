<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.framework.util.ManageConstants"%>
<%
String basePath = (String)request.getServletContext().getAttribute(ManageConstants.BASE_PATH);
String staticPath = (String)request.getServletContext().getAttribute(ManageConstants.STATIC_PATH);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>基本功能信息设置</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"></jsp:include>
<!--树形菜单控件  -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>bin/plugin/ztree/bootstrapStyle.css" />
<script type="text/javascript" src="<%=basePath%>bin/plugin/ztree/jquery.ztree.core.js" ></script>
<script type="text/javascript" src="<%=basePath%>bin/plugin/ztree/jquery.ztree.excheck.js" ></script>
<script type="text/javascript" src="<%=basePath%>bin/plugin/ztree/jquery.ztree.exedit.js" ></script>

<style>
	div.content_wrap {width: 600px;height:180px;}
	div.content_wrap div.left{float: left;width: 250px;}
	div.content_wrap div.right{float: right;width: 340px;}
	div.zTreeDemoBackground {width:200px;height:100%;text-align:left;}
	
	ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:370px;height:300px;overflow-y:scroll;overflow-x:auto;}
	ul.log {border: 1px solid #617775;background: #f0f6e4;width:300px;height:170px;overflow: hidden;}
	ul.log.small {height:45px;}
	ul.log li {color: #666666;list-style: none;padding-left: 10px;}
	ul.log li.dark {background-color: #E3E3E3;}
</style>

<script type="text/javascript">
var strMenuId = "${strMenuId}";
$('#hidMenuId').val(strMenuId);
var setting = {
		view: {
			// 设置是否可多选树节点 shift键
			selectedMulti: false 
		},
		check: {
			enable: true
		},
		async: {
			enable: true,
			url:'menuController/getBaseFuncList?strMenuId='+strMenuId
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		edit: {
			enable: false
		}
	};
  
// 页面初始化
$(document).ready(function(){
	$('#hidMenuId').val(strMenuId);
	$.fn.zTree.init($("#treeDemo"), setting);
});

//保存
function save(){
	// 获取所有选中节点的状态
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	checkCount = zTree.getCheckedNodes(true);
	var menuFuncIds = "";
	for(var i=0;i<checkCount.length;i++) {
		menuFuncIds += checkCount[i].id + ","
	}	
	// 菜单ID
	var menuId = $('#hidMenuId').val();	
		$.ajax({
			async	 : false,
			type	  : "post",
			dataType  : "json",
			url: "menuController/saveBaseFunc",
			data: {
				strMenuId: menuId,
				strMenuFuncIds:menuFuncIds
			},
			success : function(response) {
				if(response>0){
					parent.modal.close();
					parent.alertify.success("菜单功能信息设置成功!");
				}
			}
	});
}

</script>
</head>
<body>
	<div class="modal-body">
		<form id="editForm" class="form-horizontal no-margin">
			<input type="hidden" id="hidMenuId">
			<ul id="treeDemo" class="ztree"></ul>
		</form>
	</div>
	<div class="modal-footer">
		<button class="btn btn-success" type="button" onclick="save()"><i class="fa fa-check-circle"></i> 保 存</button>
		<button class="btn btn-danger" type="button" onclick="parent.modal.close()"><i class="fa fa-times-circle"></i> 取 消</button>
	</div>
</body>
</html>